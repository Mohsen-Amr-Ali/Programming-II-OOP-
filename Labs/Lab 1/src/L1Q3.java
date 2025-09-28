import java.util.Scanner;
import static java.lang.System.out;

public class L1Q3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        out.print("Enter a sentence: ");

        String sentence = scanner.nextLine();
        String[] words = sentence.trim().split("\\s+");
        out.println("Number of words: " + words.length);
    }
}