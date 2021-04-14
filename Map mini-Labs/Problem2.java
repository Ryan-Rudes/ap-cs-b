import java.io.*;
import java.util.*;

class Problem2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new HashMap<Character, Integer>() {{
            Reader reader = new FileReader("input.txt");
            int occurances;
            int letterInt = reader.read();
            char letterChar;
            int length = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                put(c, 0);
            }
            while (letterInt != -1) {
                length ++;
                letterChar = (char)letterInt;
                letterChar = Character.toLowerCase(letterChar);
                if (letterChar >= 'a' && letterChar <= 'z') {
                    put(letterChar, get(letterChar) + 1);
                }
                letterInt = reader.read();
            }
            // Output can be found in output2.txt
            FileWriter writer = new FileWriter("output2.txt");
            double percentage;
            for (char c = 'a'; c <= 'z'; c++) {
                percentage = (double)get(c) / length * 100;
                writer.write(String.format("%s %.6f%%%n", c, percentage));
            }
            writer.close();
        }};
    }
}