import java.io.*;
import java.util.Scanner;
public class Vowel {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = sc.nextLine();

        String vowels = "";
        String consonant = "";

        for (int i= 0; i<input.length();i++)
        {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                vowels += c;
            }else{
                consonant += c;
            }
        }
        try{
            FileWriter vowelFile = new FileWriter("vowels.txt");
            vowelFile.write(vowels);
            vowelFile.close();
            System.out.println("The vowels are: "+vowels);
            FileWriter consonantFile = new FileWriter("consonants.txt");
            consonantFile.write(consonant);
            consonantFile.close();
            System.out.println("The consonants are: "+ consonant);
            System.out.println("Vowels and consonants written to separate files.");

        }catch(IOException e){
            System.out.println("An error occured:");
        }



    }
}
