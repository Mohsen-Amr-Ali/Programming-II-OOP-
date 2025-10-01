import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;
import java.io.*;

public class L2Q4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        Invoice[] invoices = readInvoiceDetailsFromFile(fileName);
        invoices = Invoice.sortCostDesc(invoices);

        if (invoices == null) {
            out.println("No invoices loaded (file not found).");
            return;
        }
        out.println(invoices.length + " invoices loaded. Press Enter to continue. ");
        scanner.nextLine();

        for(Invoice invoice : invoices) {
            invoice.report();
            out.println("\n");
        }

        out.print("Number of new invoices to create: ");
        int new_inv_num = Integer.parseInt(scanner.nextLine());
        Invoice[] new_inv_arr = new Invoice[new_inv_num];

        int num = invoices.length; String name; int num_of_elements; String[] str_prcs;

        for (int i = 0; i < new_inv_num; i++) {
            num = invoices.length + i + 1;
            out.print("\nEnter account " + num + " data:-\n");
            out.print("Customer Name: ");
            name = scanner.nextLine();
            out.print("Number of elements: ");
            scanner.nextLine();
            out.print("Prices: ");
            str_prcs = scanner.nextLine().trim().split("[,\\s]+");

            double[] prcs = new double[str_prcs.length];
            int j = 0;
            for(String s : str_prcs){
                prcs[j] = Double.parseDouble(str_prcs[j++]);

            }

            Invoice inv = new Invoice(num, name, prcs);
            new_inv_arr[i] = inv;
        }

        try{
            Files.writeString(Path.of(fileName), num + "\n");

            for (Invoice inv : invoices){
                Files.writeString(Path.of(fileName), inv.parseToStr() + "\n", StandardOpenOption.APPEND);
            }

            for(Invoice inv : new_inv_arr){
                Files.writeString(Path.of(fileName), inv.parseToStr() + "\n", StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            out.println(e);
        }

    }

    public static Invoice[] readInvoiceDetailsFromFile(String file_name){
        try{
            Scanner scanner = new Scanner(new File(file_name));
            int inv_num = Integer.parseInt(scanner.nextLine());
            Invoice[] inv_arr = new Invoice[inv_num];
            int i=0;

            while(scanner.hasNext()){
                String[] line = scanner.nextLine().split(",");
                Invoice invoice = new Invoice();

                invoice.setInvoiceNumber(Integer.parseInt(line[0]));
                invoice.setCustomerName(line[1]);

                int item_num = Integer.parseInt(line[2]);
                double[] prcs = new double[item_num];
                for (int j = 0; j < item_num; j++){
                    prcs[j] = Double.parseDouble(line[2+j]);
                }
                invoice.setPrices(prcs);

                inv_arr[i++] = invoice;
            }

            return inv_arr;

        } catch (FileNotFoundException e) {
            out.println(e);
        }

        return null;
    }
}