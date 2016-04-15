//*****************************************************
//
// Steven Hernandez.
// Introduction to Programming CMSC 255-002 Spring 2016
// MatchUp.java
// Project: 6
// Matching Brackets.
//
//*****************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchUp {

public static void main (String[] args) {
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
        } catch (FileNotFoundException e) {
                // we already decided that the file exists, but this is still required.
                System.out.println("File Not Found.");
                return;
        }

        /*
         * Now start processing that file
         */

        int currentIndex = 0;

        while(file_in.hasNextLine()) {
                String line = file_in.nextLine();

                for(int i = 0; i < line.length(); i++) {
                        char character = line.charAt(i);
                        System.out.print(character);
                        switch (character) {
                        case '{':
                                currentIndex++;
                                System.out.print(currentIndex);
                                break;
                        case '}':
                                System.out.print(currentIndex);
                                currentIndex = currentIndex > 0 ? currentIndex - 1 : 0;
                                break;
                        default:
                                break;
                        }
                }

                System.out.println();
        }

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
        System.out.println("MatchUp.java");
        System.out.println("Project: 6");
        System.out.println("Matching Brackets.");
        System.out.println();
}
}


/*
{} Don't number these
*/

//   {} Don't number these

public static String test = "{} Nor these";
