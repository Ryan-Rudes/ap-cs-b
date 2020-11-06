import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Main {
    /**
     * Return the number of digits in an integer
     * Converts the integer to a string and returns its length
     * 
     * @param number  an integer value
     */
    public static int numDigits(int number) {
        return String.valueOf(number).length();
    }

    /**
     * Returns the maximum number of digits of any integer in a LinkedList object
     *  
     * @param list  a LinkedList object, storing integer values
     */
    public static int maxLength(LinkedList list) {
        ListIterator<Integer> iterator = list.listIterator();
        int maxDigits = 0;
        int digits;

        while (iterator.hasNext()) {
            digits = numDigits(iterator.next());

            if (digits > maxDigits)
                maxDigits = digits;
        }

        return maxDigits;
    }

    /**
     * Returns the digit value at a particular place value of a number
     *  
     * @param number  an integer value
     * @param digit   an integer value, indicates the place value, counting from the left at 0
     */
    public static int getRadix(int number, int digit) {
        String digitString = String.valueOf(number);
        int numDigits = digitString.length();

        if (digit < numDigits) {
            return Character.getNumericValue(digitString.charAt(numDigits - (digit + 1)));
        } else {
            return 0;
        }
    }

    /**
     * Sorts a LinkedList of integer values, returning the sorted LinkedList
     */
    public static LinkedList RadixSort(LinkedList list) {
        LinkedList[] bins = new LinkedList[10];
        int number, radix;
        ListIterator<Integer> iterator;
        
        for (int digit = 0; digit < maxLength(list); digit++) {
            // Assign each bin to an empty LinkedList, each corresponding to a particular radix
            for (int i = 0; i < 10; i++)
                bins[i] = new LinkedList();

            // Iterate through the list parameter, sorting items into the approperiate radix bin
            iterator = list.listIterator();
            
            while (iterator.hasNext()) {
                number = iterator.next();
                radix = getRadix(number, digit);
                bins[radix].addLast(number);
            }

            // Collect the bins into a new LinkedList for the next phase of the sorting algorithm
            list = new LinkedList();

            for (LinkedList bin: bins) {
                iterator = bin.listIterator();

                while (iterator.hasNext()) {
                    list.addLast(iterator.next());
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // Random number generator
        Random rand = new Random();
        // Empty LinkedList
        LinkedList list = new LinkedList();
    
        // Fill the LinkedList with 20 random, unsorted numbers
        for (int i = 0; i < 20; i++) {
          list.add(rand.nextInt(100));
        }
    
        // Print the LinkedList, before and after sorting
        System.out.println(list);
        list = RadixSort(list);
        System.out.println(list);
    }
}