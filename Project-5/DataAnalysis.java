//*****************************************************
//
// Steven Hernandez.
// Introduction to Programming CMSC 255-002 Spring 2016
// DataAnalysis.java
// Project: 5
// Detecting Heat waves.
//
//*****************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

  public static void main(String[] args)
  {
    printHeading();

    String errors_string = "";

    /*
     * establish which file the user wants to use
     */

    //check that a command line argument was passed
    String filename = (args.length != 0) ? args[0] : "";
    if (filename == "") {
      System.out.println("No filename found when running command. Example: ");
      System.out.println("java DataAnalaysis example.txt");
    }

    File file = getFile(filename);

    Scanner file_in;

    try {
      file_in = new Scanner(file);
    } catch (FileNotFoundException e) {
      // we already decided that the file exists, but this is still required.
      System.out.println("File Not Found.");
      return;
    }

    /*
     * Now retrieve and process the data from the file
     */

    //get `month year`
    String month_year = file_in.nextLine();
    String month = month_year.split(" ")[0]; // first word should be the month

    int numDaysInMonth;
    try {
      numDaysInMonth = numDaysInMonth(month);
    } catch (Exception e) {
      System.out.println(e);
      return;
    }

    // store each line value into array
    int[] values = new int[numDaysInMonth];
    int values_i = 0;
    while(file_in.hasNextLine()) {
      String data_line = file_in.nextLine().trim();
      try {
        int temp = Integer.parseInt(data_line);

        // only add to the array if we expect there to be more days in the month
        if (values_i < numDaysInMonth) {
          values[values_i] = temp;
        }

        // continue iterating values_i just to see how many more there are
        values_i++;
      }
      catch (NumberFormatException e) {
        // Not An Integer
        errors_string += "Line Parse Error: skipped value `" + data_line + "`\n";
      }
    }

    double average = calculateAverage(values);

    // Print Header
    System.out.println("The average temperature for " + month_year + " was " + average);

    int max = Math.min(values_i, numDaysInMonth); // max rows to print

    // Print row
    for (int i = 0; i < max; i++) {
      System.out.printf("%3d ", i + 1);
      System.out.print(values[i]);

      //decide if we need to place a `+`
      if (values[i] > average) {
        int consecutivelyHigherThenAverage = 1; // because i > average
        if (i - 1 >= 0) { // check i - 1 exists
          if (values[i - 1] > average) { // check i - 1 > average
            consecutivelyHigherThenAverage++;
            if (i - 2 >= 0) { // check i - 2 exists
              consecutivelyHigherThenAverage += values[i - 2] > average ? 1 : 0; // check i - 2 > average
            }
          }
        }
        if (i + 1 < max) { // check i + 1 exists
          if (values[i + 1] > average) { // check i + 1 > average
            consecutivelyHigherThenAverage++;
            if (i + 2 < max) { // check i + 2 exists
              consecutivelyHigherThenAverage += values[i + 2] > average ? 1 : 0; // check i + 2 > average
            }
          }
        }
        if (consecutivelyHigherThenAverage >= 3) System.out.print(" +");
      }

      //formatting line
      System.out.println();
    }

    /*
     * Print out information about errors
     */
     if (!errors_string.isEmpty() || values_i != numDaysInMonth) {
       System.out.println("\nNOTICE: There were some errors with your data:");
       if (values_i != numDaysInMonth) {
         System.out.println("There number of lines of data was different then the number of days expected in the month.");
         System.out.println(values_i + " lines of data, but " + numDaysInMonth + " days expect for the month");
       }
       System.out.println(errors_string);
     }
  }

  private static double calculateAverage(int[] values)
  {
    int total = 0;
    for (int temp: values) total += temp;
    return total / values.length;
  }

  /*
   * @param filename - from command line
   */
  private static File getFile(String filename) {
    File file = new File(filename);
    while (!file.exists()) {
      if (!filename.isEmpty()) System.out.println("That file doesn't seem to exist.");
      System.out.println("Please enter a file.");
      Scanner in = new Scanner(System.in);
      filename = in.next();
      file = new File(filename);
    }
    return file;
  }

  private static int numDaysInMonth(String month) throws Exception {
    switch (month.toLowerCase()) {
      case "january":
      case "march":
      case "may":
      case "july":
      case "august":
      case "october":
      case "december":
        return 31;
      case "april":
      case "june":
      case "deptember":
      case "november":
        return 30;
      case "february":
        return 28;
      default:
        throw new Exception("'" + month + "' doesn't seem to be a month we can use.");
    }
  }

  /*
   *
   * Use this portion of code for all project in this course
   * Replace these variables per project
   *
   */
  private static void printHeading()
  {
    // Print out the Heading (reuse for each project)
    System.out.println("Steven Hernandez.");
    System.out.println("Introduction to Programming CMSC 255-002 Spring 2016");
    System.out.println("DataAnalysis.java");
    System.out.println("Project: 5");
    System.out.println("Detecting Heat Waves.");
    System.out.println();
  }
}
