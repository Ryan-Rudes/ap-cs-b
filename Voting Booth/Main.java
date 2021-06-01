import java.io.*;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

/*
DATA STRUCTURES INCORPORATED:
    - HashMap
    - List

Only one pass through each input file is necessary, as each key is dynamically updated; its value is incremented each time
a student's name appears. A nest of 16 HashMaps are used, and they are accessed first by the category number 0-15, then by
the student's name.

After processing all input data, one pass through each of the 15 HashMaps finds the key-value pairs with the top-3 values.

Both components of this process operate in O(n), and thus the overall procedure runs in O(n).
*/

public class Main {
    public static void reportWinners(String sex) throws FileNotFoundException {
        HashMap<Integer, HashMap<String, Integer>> results = new HashMap<Integer, HashMap<String, Integer>>() {{
            File file = new File(sex + ".txt");
            Scanner reader = new Scanner(file);
            
            for (int i = 0; i < 16; i++) {
                put(i, new HashMap<String, Integer>());
            }

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isBlank()) {
                    String[] names = line.split(",", -1);
    
                    for (int i = 0; i < 16; i++) {
                        if (!names[i].isEmpty()) {
                            int count = get(i).getOrDefault(names[i], 0);
                            get(i).put(names[i], count + 1);
                        }
                    }
                }
            }

            reader.close();
        }};

        File file = new File("categories.txt");
        Scanner reader = new Scanner(file);

        System.out.println(sex.toUpperCase() + ":");
        
        for (int i = 0; i < 16; i++) {
            String category = reader.nextLine();
            category = category.substring(1, category.length() - 2);

            List<HashMap.Entry<String, Integer>> winners = results.get(i)
                                                            .entrySet()
                                                            .stream()
                                                            .sorted(comparing(HashMap.Entry::getValue, reverseOrder()))
                                                            .limit(3)
                                                            .collect(toList());

            ListIterator<HashMap.Entry<String, Integer>> it = winners.listIterator();

            System.out.print(category + ": ");

            while (it.hasNext()) {
                HashMap.Entry<String, Integer> winner = it.next();
                System.out.print(String.format("#%d is %s with %d votes. ", it.nextIndex(), winner.getKey(), winner.getValue()));
            }

            System.out.println();
        }

        System.out.println();
    }
    public static void main(String[] args) throws FileNotFoundException {
        reportWinners("male");
        reportWinners("female");
    }
}