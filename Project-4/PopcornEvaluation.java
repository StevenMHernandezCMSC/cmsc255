import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PopcornEvaluation {
  
  final static int MIN_COL_LENGTH = 24;
  
  public static void main(String[] args) throws FileNotFoundException { 
    // request filename
    Scanner in = new Scanner(System.in);
    System.out.println("Input filename: ");
    String filename = in.next();
    
    // load file
    File file = new File(filename);

    while (!file.exists()) {
      // re-request filename
      System.out.printf("Looks like the file `%s` doesn't exist.\n", filename);
      System.out.println("Input another filename: ");
      filename = in.next();
      file = new File(filename);
    }

    Scanner fileReader = new Scanner(file);
    
    // table heading
    System.out.println("                    Popcorn Co-op");
    System.out.println();
    System.out.println("                              Production in Hundreds");
    System.out.println("                              of Pint Jars per Acre");
    System.out.println("Farm Name                        1   2   3   4   5   6");
    System.out.println("                              ---|---|---|---|---|---|");
    
    // foreach line
    while (fileReader.hasNextLine()) {
      String line = fileReader.nextLine();
      printFormatted(parseFarmName(line), parsePintsPerAcre(line));
    }
  }
  
  public static String parseFarmName(String line) {
    return line.split(",")[0].trim();
  }
  
  public static double parsePintsPerAcre(String line) {
    Scanner scan = new Scanner(line.split(",")[1]);
    
    double acres = scan.nextDouble();
    double pints = scan.nextDouble();
    return pints / acres;
  }
  
  public static void printFormatted(String farmName, double pintsPerAcre) {
    System.out.print(farmName);
    // padding for name
    for (int i = 0; i < 30 - farmName.length(); i++) {
      System.out.print(" ");
    }
    
    int columnLength = (int)pintsPerAcre / 25;
    if (columnLength < MIN_COL_LENGTH) columnLength = MIN_COL_LENGTH;
    for (int i = 0; i < columnLength; i++) {
      char star = pintsPerAcre > 25 ? '*' : ' ';
      if (i == 5 * 4 - 1) star = pintsPerAcre > 25 ? '#' : '|';
      System.out.print(star);
      pintsPerAcre = pintsPerAcre - 25;
    }
    
    System.out.println();
  }
}
