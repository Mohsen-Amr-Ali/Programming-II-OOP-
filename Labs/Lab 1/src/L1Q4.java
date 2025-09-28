import java.util.Scanner;
import static java.lang.System.out;

public class L1Q4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        out.print("How many numbers? ");
        int n = scanner.nextInt();

        int arr[] = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0, x; i < n; i++) {
            out.print("\nEnter number " + (i+1) + ": ");
            x = scanner.nextInt();

            if(x < min) min = x;
            if(x > max) max = x;

            arr[i] = x;
        }

        out.println("\nMaximum Value: " + max + " | Minimum Value: " + min);
    }
}