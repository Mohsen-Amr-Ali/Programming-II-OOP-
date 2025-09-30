import java.util.Scanner;
import static java.lang.System.out;

public class L2Q1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        out.print("Enter 3 positive integers seperated by '-: ");
        String input = scanner.nextLine();
        String numbers[] = input.split("-");

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }

        if(arr[0] == arr[1] && arr[1] == arr[2]){
            out.println("\nAll Equal.");
        } else if(arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]){
            out.println("\nAll different.");
        } else out.print("Neither.");
    }
}