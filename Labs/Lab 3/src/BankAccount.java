import java.util.Scanner;
import static java.lang.System.out;
import java.util.Random;
import java.util.ArrayList;

public class BankAccount {
    //-------- members -------//
    private int account_num;
    private String account_holder;
    private double balance;

    private static final ArrayList<Integer> accounts = new ArrayList<Integer>();
    private static final Random random = new Random();

    //------- constructors -------//
    public BankAccount(){}

    public BankAccount(String account_holder){
        int account_num;
        do {
            account_num = 100000 + random.nextInt(900000);
        }while(accounts.contains(account_num));

        this.account_num = account_num;
        accounts.add(account_num);

        setAccountHolder(account_holder);
        this.balance = 0;
    }

    //------- getters & setters------//

    // account number
    public int getAccountNum() {
        return account_num;
    }

    //No setter since it shouldn't be changed

    // account holder name
    public String getAccountHolder() {
        return account_holder;
    }

    public void setAccountHolder(String account_holder) {
        if (account_holder == null || account_holder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty or null.");
        }
        this.account_holder = account_holder.trim();
    }

    // balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    //-------- methods --------//
    public void depositMoney(Scanner scanner){
        boolean valid; double amount;

        do{
            valid = true;
            out.print("Enter deposit amount [0 to cancel]: ");
            amount = Double.parseDouble(scanner.nextLine());
            if(amount < 0){
                out.println("Invalid amount. Amount must be more than 0. Try again.\n");
                valid = false;
            } else if(amount == 0){
                out.println("Deposit cancelled.\n");
                return;
            }
        }while(!valid);

        this.balance += amount;
        out.println("Deposited " + amount + "EGP successfully.\n");
    }

    public void withdrawMoney(Scanner scanner) {
        if(this.balance == 0){
            out.println("Insufficient funds. Balance is currently 0. Withdrawal failed.\n");
            return;
        }

        boolean valid; double amount;

        do {
            valid = true;
            out.print("Enter withdrawal amount [0 to cancel]: ");
            amount = Double.parseDouble(scanner.nextLine());

            if (amount < 0) {
                out.println("Invalid amount. Amount must be more than 0. Try again.\n");
                valid = false;
            } else if (amount > this.balance) {
                out.println("Insufficient funds. Withdrawal failed.\n");
                valid = false;
            } else if(amount == 0){
                out.println("Withdrawal Cancelled.\n");
                return;
            }
        } while (!valid);

        this.balance -= amount;
        out.println("Withdrawed " + amount + "EGP successfully.\n");
    }

    public void checkBalance(){
        out.printf("\nCurrent balance: .%2f EGP", this.balance);
    }

}
