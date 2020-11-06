<img src="https://i.ibb.co/ydZQCKf/days-Apart-1.jpg" alt="days-Apart-1" border="0">

# Code
**Date.java**
```java
class Date {
  // Instance variables for the Date object
  int year, month, day;
  // The number of days in each month in a standard year
  int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  // The number of days between January 1st and the beginning of each month in a standard year
  int[] daysUntilMonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

  /*
  * Class constructor for integer date parameters input
  * 
  * year:  the associated year as an integer
  * month: the associated month as an integer between 1 and 12, inclusive
  * day:   the associated day as an integer
  * 
  * Throws an assertion error if the date entered does not exist
  */
  public Date(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;

    if (day > daysPerMonth[month - 1] + (isLeapYear() && month == 2 ? 1 : 0)) {
      throw new AssertionError(String.format("Encountered an invalid date: %02d/%02d/%d", month, day, year));
    }
  }

  /*
  * Overloaded class constructor for String input with format: MM/DD/YYYY
  * 
  * date: the associated date as a String with format: MM/DD/YYYY
  * 
  * Throws an assertion error if the date entered does not exist
  */
  public Date(String date) {
    String[] params = date.split("/");
    this.month = Integer.valueOf(params[0]);
    this.day = Integer.valueOf(params[1]);
    this.year = Integer.valueOf(params[2]);
    	
    if (day > daysPerMonth[month - 1] + (isLeapYear() && month == 2 ? 1 : 0)) {
      throw new AssertionError(String.format("Encountered an invalid date: %02d/%02d/%d", month, day, year));
    }
  }

  /*
  * Determines whether the associated year is a leap year.
  * 
  * If the year is divisible by 4, it is a leap year, except for the following exception:
  * If the year divides 100, it must also divide 400 in order to be considered a leap year.
  * 
  * Examples:
  *   - 1492: true
  *   - 2020: true
  *   - 1900: false
  *   - 2000: true
  */
  private boolean isLeapYear() {
    return year % 4 == 0 && !((year % 100 == 0) ^ (year % 400 == 0));
  }

  /*
  * Computes the number of days (including leap days) between January 1st 0001 and the
  * associated date.
  * 
  * Consider three sets: A, B, C, as follows:
  *   - A: The number of years less than the associated year which are divisible by 4
  *   - B: The number of years less than the associated year which are divisible by 100
  *   - C: The number of years less than the associated year which are divisible by 400
  *
  * Given these sets, the number of leap years that have occurred between 0001 and the
  * associated year is equal to A - B + C (refer to the requirements for a leap year),
  * as referenced above the isLeapYear method.
  * 
  * Note that the total number of days (excluding leap days) between January 1st 0001 and
  * January 1st of the associated year is equal to (year - 1) * 365.
  * 
  * To obtain the total number of days (including leap days) between January 1st 0001 and
  * January 1st of the associated year, we can add the number of leapdays to (year - 1) * 365,
  * resulting in the following: (year - 1) * 365 + A - B + C
  */
  private int zeroToYear() {
    int lastYear = year - 1;
    int A = Math.floorDiv(lastYear, 4);
    int B = Math.floorDiv(lastYear, 100);
    int C = Math.floorDiv(lastYear, 400);
    return (365 * lastYear) + A - B + C;
  }

  /*
  * Computes the number of days (including leap days) between January 1st of the associated year
  * and the 1st of the associated month and year.
  * 
  * The desired output can be divided into two parts:
  *   1. The number of days between January 1st of the associated year and the 1st of the
  *      associated month and year
  *   2. The number of leap days between January 1st of the associated year and the 1st of the
  *      associated month and year (simply whether it is both a leap year and leap day has
  *      already passed)
  * 
  * Therefore, we simply refer to daysUntilMonth for the number of days before the associated month,
  * then, we add 1 if it is a leap year and we already passed leap day.
  */
  private int yearToMonth() {
    return daysUntilMonth[month - 1] + ((isLeapYear() && month > 2) ? 1 : 0);
  }

  /*
  * Computes the number of days (including leap days) between January 1st 0001 and the associated year.
  * 
  * The desired output can be divided into the following parts:
  *   1. The number of days (including leap days) between January 1st 0001 and the associated date
  *   2. The number of days (including leap days) between January 1st of the associated year and
  *      the 1st of the associated year-month
  *   3. The number of days between the 1st of the associated year-month and the current year-month-day
  *      (a.k.a. the day of the month)
  * 
  * Taking the sum of these will return the total number of days (including leap days) between
  * January 1st 0000 and the associated date.
  */
  public int timeSinceZero() {
    return zeroToYear() + yearToMonth() + day;
  }

  /*
  * Overrides the print output method.
  * 
  * This method causes it to print the date in MM/DD/YYYY format when a print function containing
  * the Date object is called.
  */
  public String toString() {
    return String.format("%02d/%02d/%d", month, day, year);
  }
}
```

**Main.java**
```java
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
```
