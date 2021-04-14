import java.io.*;
import java.util.*;

class Problem3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        TreeMap<String, Integer> names = new TreeMap<String, Integer>() {{
            // Names list sourced from
            // https://github.com/FinNLP/humannames/blob/master/list.txt
            File file = new File("names.txt");
            Scanner input = new Scanner(file);
            String name;
            while (input.hasNext()) {
                name = input.next();
                name = name.toLowerCase();
                name = name.replaceAll("[^a-z]", "");
                put(name, 0);
            }
        }};
        // Output can be found in output3.txt
        FileWriter writer = new FileWriter("output3.txt");
        double percentage;
        for (String name: names.keySet())
            writer.write(name + "\n");
        writer.close();
    }
}