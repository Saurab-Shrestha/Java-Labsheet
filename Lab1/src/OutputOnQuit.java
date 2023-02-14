import java.io.*;
import java.util.Scanner;

public class OutputOnQuit {
    public static void main(String[] args) throws IOException {

        // Open the file
        File file=new File("OutputOnQuit.txt");
        FileWriter fr=new FileWriter(file);
        PrintWriter outputFile = new PrintWriter(fr);

        // Read lines from the keyboard and write them to the file
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            System.out.print("Enter a line (type 'quit' to exit): ");
            line = scanner.nextLine();
            if (line.equals("quit")) {
                break;
            }
            outputFile.println(line);
        }

        // Close the file
        outputFile.close();
    }
}
