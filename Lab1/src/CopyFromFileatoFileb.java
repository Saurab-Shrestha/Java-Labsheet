// Java program to copy content from
// one file to another
import java.io.*;
import java.util.*;
public class CopyFromFileatoFileb {

    static void copyContent(File a, File b) throws  Exception
    {
        FileInputStream in = new FileInputStream(a);
        FileOutputStream out = new FileOutputStream(b);

        try {
            int n;
            while ((n = in.read()) != -1)
            {
                out.write(n);
                out.write(n);
            }
        }
        finally {
            if(in!=null){
                in.close();
            }
            if (out!=null){
                out.close();
            }
        }
        System.out.println("File Copied");
    }
    public static  void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the source filename from where you have to read/copy");
        String a = sc.nextLine();

        //source file
        File x = new File(a);

        //get the destination file name
        System.out.println("Enter destination filename: ");
        String b = sc.nextLine();

        // destination file
        File y = new File(b);

        copyContent(x,y);
    }
}
