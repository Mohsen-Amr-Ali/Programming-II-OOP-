import java.util.Scanner;
import static java.lang.System.out;

public class L2Q3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;
        String name;
        int num_of_elements;
        String[] str_prcs;

        out.print("\nEnter account 1 data: \nInvoice Number:");
        num = Integer.parseInt(scanner.nextLine());
        out.print("Customer Name: ");
        name = scanner.nextLine();
        out.print("Number of elements: ");
        scanner.nextLine();
        out.print("Prices: ");
        str_prcs = scanner.nextLine().trim().split("[,\\s]+");

        double[] prcs = new double[str_prcs.length];
        int i = 0;
        for(String s : str_prcs){
            prcs[i] = Double.parseDouble(str_prcs[i++]);

        }

        Invoice inv1 = new Invoice(num, name, prcs);

        out.print("\nEnter account 2 data: \nInvoice Number:");
        num = Integer.parseInt(scanner.nextLine());
        out.print("Customer Name: ");
        name = scanner.nextLine();
        out.print("Number of elements: ");
        scanner.nextLine();
        out.print("Prices: ");
        str_prcs = scanner.nextLine().trim().split("[,\\s]+");

        double[] prcs2 = new double[str_prcs.length];
        i = 0;
        for(String s : str_prcs){
            prcs2[i] = Double.parseDouble(str_prcs[i++]);

        }

        Invoice inv2 = new Invoice(num, name, prcs2);

        out.println("\nData of the first account:");
        inv1.report();
        out.println("\nData of the second account:");
        inv2.report();
    }
}