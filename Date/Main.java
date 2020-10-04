// Import for the absolute value function
import static java.lang.Math.abs;
// Imports relating to file functions
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
  /*
  * Computes the number of days (including leap days) separating two Date objects
  * 
  * The Date class already defines a method to compute the number of days (including
  * leap days) between January 1st 0000 and the associated date.
  * 
  * Therefore, we can simply take the absolute difference between these to get the
  * desired output.
  */
  static int daysApart(Date day1, Date day2) {
    return abs(day1.timeSinceZero() - day2.timeSinceZero());
  }

  public static void main(String[] args) throws FileNotFoundException {
    // String variable to store each line when reading the test cases text file
    String line;
    // Integer variable to store the difference between each pair of dates
    int difference;
    // Instantiation of two date objects for future assignment and comparison
    Date day1, day2;

    // Text file containing test cases
    File testCasesFile = new File("Date_Data.txt");
    // A scanner object to read the text file
    Scanner reader = new Scanner(testCasesFile);

    // While their is another test case to read...
    while (reader.hasNextLine()) {
      // Read the line
      line = reader.nextLine();
      // Extract the two date strings between the quotation marks
      day1 = new Date(line.substring(1, 11).strip());
      day2 = new Date(line.substring(15, 25).strip());
      // Compute the difference between the dates via existing methods of the Date class
      difference = daysApart(day1, day2);
      // Print a message in the format: "MM/DD/YYYY and MM/DD/YYYY are x days apart"
      System.out.printf("%s and %s are %d days apart%n", day1, day2, difference);
    }

    // Close the scanner object
    reader.close();
  }

  /*
  * EXPECTED BEHAVIOR:
  * 
  * There is a non-existant date in the text file (02/30/1996).
  * This should raise in Exception. Apart from that, the first
  * four pairs of dates (those preceding the invalid pair)
  * are 0, 1, 365, and 424 days apart, respectively.
  */
}