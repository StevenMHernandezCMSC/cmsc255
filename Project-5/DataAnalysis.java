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
    }
    catch (FileNotFoundException e) {
      // we already decided that the file exists, but this is required.
      System.out.println("File Not Found.");
      return;
    }

    /*
     * Now retreive and process the data from the file
     */

    //get `month year`
    String month_year = file_in.nextLine();
    String month = month_year.split(" ")[0];

    int numDaysInMonth;
    try {
      numDaysInMonth = numDaysInMonth(month);
    } catch (Exception e){
      System.out.println(e);
      return;
    }

    // store each line value into array
    ArrayList <Integer> values = new ArrayList <Integer>();
    while(file_in.hasNextLine()) {
      try {
        int temp = Integer.parseInt(file_in.nextLine());
        values.add(temp);
      }
      catch (NumberFormatException e) {
        // Not An Integer
      }
    }

    double average = calculateAverage(values);

    // Print Header
    System.out.println("The average temperature for " + month_year + " was " + average);

    // Print row
    for (int i = 0; i < values.size(); i++) {
      System.out.printf("%3d ", i + 1);
      System.out.print(values.get(i));

      //decide if we need to place a `+`
      if (values.get(i) > average) {
        int consecutivelyHigherThenAverage = 1; // because i > average
        if (i - 1 >= 0) { // check i - 1 exists
          if (values.get(i - 1) > average) { // check i - 1 > average
            consecutivelyHigherThenAverage++;
            if (i - 2 >= 0) { // check i - 2 exists
              consecutivelyHigherThenAverage += values.get(i - 2) > average ? 1 : 0; // check i - 2 > average
            }
          }
        }
        if (i + 1 < values.size()) { // check i + 1 exists
          if (values.get(i + 1) > average) { // check i + 1 > average
            consecutivelyHigherThenAverage++;
            if (i + 2 < values.size()) { // check i + 2 exists
              consecutivelyHigherThenAverage += values.get(i + 2) > average ? 1 : 0; // check i + 2 > average
            }
          }
        }
        if (consecutivelyHigherThenAverage >= 3) System.out.print(" +");
      }

      //formatting line
      System.out.println();
    }
  }

  private static double calculateAverage(ArrayList <Integer> values)
  {
    int total = 0;
    for(int temp: values) {
      total += temp;
    }
    return total / values.size();
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
        throw new Exception("'" + month + "' doesn't seem to a month we can use.");
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
