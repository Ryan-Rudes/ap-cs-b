import java.io.*;
import java.util.*;

class Problem1 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> frequency = new HashMap<String, Integer>() {{
            File file = new File("input.txt");
            Scanner input = new Scanner(file);
            String word;
            int occurances;
            while (input.hasNext()) {
                word = input.next();
                word = word.toLowerCase();
                word = word.replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    putIfAbsent(word, 0);
                    put(word, get(word) + 1);
                }
            }
        }};
        // Output can be found in output1.txt
        System.out.println(frequency);
    }
}