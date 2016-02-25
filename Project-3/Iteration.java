//*****************************************************
//
// Steven Hernandez.
// Introduction to Programming CMSC 255-002 Spring 2016
// Selection.java
// Project: 3
// Iteration and Reading Files
//
//*****************************************************

import java.util.Scanner;
import java.io.*;

class Iteration {
/*
 *
 * Use this portion of code for all project in this course
 * Replace these variables per project
 *
 */
private static void printHeading() {
        // Print out the Heading (reuse for each project)
        System.out.println("Steven Hernandez.");
        System.out.println("Introduction to Programming CMSC 255-002 Spring 2016");
        System.out.println("Iteration.java");
        System.out.println("Project: 3");
        System.out.println("Iteration and Reading Files");
        System.out.println();
}


/*
 *
 * Actual Project Code
 *
 */
public static void main (String[] args) throws IOException {
        printHeading();

        //project code
        String filename;
        Scanner file;
        Scanner keyboard = new Scanner(System.in);

        //ask for filename
        System.out.println("What file would you like to use?");
        filename = keyboard.next();

        //test if file exists
        if (new File(filename).exists()) {
                //load file in
                file = reloadFile(filename);

                int line_count = 0; // line count so that we can figure out how many spaces to allot for line numbers.
                //for each line in file
                while(file.hasNextLine()) {
                        String line = file.nextLine();
                        line = line.trim();
                        //if line character count is not 0
                        if(line.length() > 0) {
                                //line-count gets line-count + 1
                                line_count++;
                        }
                }

                //build format_string "current_line. line_string"
                String format_string = "%" + Integer.toString(line_count).length() + "d.  %s\n";

                //reload file
                file = reloadFile(filename);

                //for each line in file
                int current_line = 1;
                while(file.hasNextLine()) {
                        String line = file.nextLine();
                        //if line character count is not 0
                        if(line.trim().length() > 0) {
                                //print line with formatted prepended string
                                System.out.printf(format_string, current_line, line);
                                current_line++;
                        } else {
                                System.out.println(line);
                        }
                }
        } else {
                System.out.printf("It looks like the file '%s' does not exist.", filename);
        }

}

public static Scanner reloadFile(String filename) throws IOException {
        return new Scanner(new FileReader(filename));
}

}
