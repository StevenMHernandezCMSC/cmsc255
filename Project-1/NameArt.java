//*****************************************************
//
// Steven Hernandez.
// Introduction to Programming CMSC 255-002 Spring 2016
// NameArt.java
// Project: 1
// My Name in Code
//
//*****************************************************

public class NameArt {

 /*
  * 
  * Use this portion of code for all project in this course
  * Replace these variables per project
  * 
  */
 public static String project_file_name = "NameArt.java";
 public static int project_number = 1;
 public static String project_description = "My Name in Code";

 private static void printHeading() {
  // Print out the Heading (reuse for each project)
  System.out.println("Steven Hernandez.");
  System.out.println("Introduction to Programming CMSC 255-002 Spring 2016");
  System.out.println(project_file_name);
  System.out.println("Project: " + project_number);
  System.out.println(project_description);
  System.out.println();
 }

 /*
  * 
  * Actual Project Code
  * 
  */
 public static void main(String[] args) {
  // always use at the beginning of the projects in this course
  printHeading();

  printName();
 }

 public static void printName() {
  System.out.println(" |||  ||||| ||||| |   | ||||| |   |");
  System.out.println("|       |   |     |   | |     ||  |");
  System.out.println(" |||    |   |||   |   | |||   | | |");
  System.out.println("    |   |   |      | |  |     |  ||");
  System.out.println(" |||    |   |||||   |   ||||| |   |");
 }
}
