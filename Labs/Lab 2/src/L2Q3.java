import java.util.Scanner;
import static java.lang.System.out;

class Invoice{
    private int invoiceNumber;
    private String customerName;
    private double[] prices;

    Invoice(int num, String name, double[] prices){
        this.invoiceNumber = num;
        this.customerName = name;
        this.prices = new double[prices.length];
        System.arraycopy(prices, 0, this.prices, 0, prices.length);
    }

    public void report(){
        double total = 0;
        for(double price: this.prices){
            total += price;
        }

        out.printf("Account Number: %d%nName: %s%nTotal Cost: %.2f%nThe total cost after discount = %.2f%n",
                this.invoiceNumber, this.customerName, total, this.calculateInvoice());

    }

    public double calculateInvoice(){
        double total = 0;
        for(double price : this.prices){
            total += price;
        }

        double price_rate = 1;
        if(total >= 10000) price_rate = 0.92;
        else if(total >= 8000) price_rate = 0.94;
        else if(total >= 5000) price_rate = 0.96;
        else if(total >= 1000) price_rate = 0.99;

        return total*price_rate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }
}

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
        num_of_elements = Integer.parseInt(scanner.nextLine());
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
        num_of_elements = Integer.parseInt(scanner.nextLine());
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