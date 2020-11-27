import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    public String read(String filepath) {
        try {
            File f = new File(filepath);
            Scanner scanner = new Scanner(f);
            String data = scanner.nextLine();
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}