package Utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TxtUtils {
    public static String readTxt(String filename) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(filename), "UTF-8");
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return sb.toString();
    }

    public static void writeTxt(String filename, String content) throws Exception {
        PrintWriter writer = new PrintWriter(new File(filename), "UTF-8");
        writer.print(content);
        writer.close();
    }
}
