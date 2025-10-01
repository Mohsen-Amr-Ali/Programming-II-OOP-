import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.out;

public class Invoice{
    private int invoiceNumber;
    private String customerName;
    private double[] prices;

    //----------------- constructors ------------------//
    public Invoice(int num, String name, double[] prices){
        this.invoiceNumber = num;
        this.customerName = name;
        this.prices = new double[prices.length];
        System.arraycopy(prices, 0, this.prices, 0, prices.length);
    }

    public Invoice() {
        this.invoiceNumber = 0;
        this.customerName = "";
        this.prices = new double[0];
    }


    //------------------ methods -------------------//
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

    public static Invoice[] sortCostDesc(Invoice[] inv_arr){
        //this is an anonymous class, not a class, an anonymous class is a
        //nameless class created for a one time use, usually to implement an interface as is with this case.
        //Comparator<T> is an interface, not a class, it's like a blueprint containing only the... zay el prototype keda,
        //el exact definition lazem nektebo be nafsena.
        Arrays.sort(inv_arr, new Comparator<Invoice>() {
            @Override
            public int compare(Invoice o1, Invoice o2) {
                return Double.compare(o2.calculateInvoice(), o1.calculateInvoice());
            }
        });

        return inv_arr;
    }

    public String parseToStr(){
        String str = this.invoiceNumber + "," +
                this.customerName + "," +
                this.prices.length + ","
        ;

        for(int j = 0; j<this.prices.length; j++){
            str = str.concat(""+ this.prices[j]);
            if(j+1 < this.prices.length)
                str = str.concat(",");
        }

        return str;
    }

    //------------ getters & setters ------------//
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