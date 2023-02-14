import java.io.*;

public class ReadLines {
    public static void main(String[] args) throws IOException {

        File file=new File("Demo.txt");
        FileReader fr=new FileReader(file);
        // Open the file
        BufferedReader inputFile = new BufferedReader(fr);

        // Read and output the file, one line at a time
        String line;
        while ((line = inputFile.readLine()) != null) {
            System.out.println(line);
        }

        // Close the file
        inputFile.close();
    }
}
