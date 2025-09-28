import java.util.Scanner;
import static java.lang.System.out;

public class L1Q1{
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        out.print("Enter the number: ");

        int number = x.nextInt();
        if(number == 0){
            out.println(number + " is zero.");
        }else{
            if(isPositive(number)) out.print(number + " is positive");
            else out.print(number + " is negative");

            if(isOdd(number)) out.println(" and odd");
            else out.println(" and even.");
        }

    }

    public static boolean isOdd(int x){
        return x % 2 == 1;
    }


    public static boolean isPositive(int x){
        return x > 0;
    }
}