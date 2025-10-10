import java.util.Scanner;
import static java.lang.System.out;

public class L3Q2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("=========================================");
        out.println("      Welcome to Java Bank | 9655        ");
        out.println("=========================================\n");

        out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        BankAccount account = new BankAccount(name);

        out.println("\nAccount successfully created!");
        out.println("-----------------------------------------");
        out.printf("Account Holder : %s%n", account.getAccountHolder());
        out.printf("Account Number : %06d%n", account.getAccountNum());
        out.printf("Starting Balance: %.2f EGP%n", account.getBalance());
        out.println("-----------------------------------------\n");

        int choice = 0;
        do {
            out.println("=========== MAIN MENU ===========");
            out.println("1. Check Balance");
            out.println("2. Deposit Money");
            out.println("3. Withdraw Money");
            out.println("4. Exit");
            out.println("=================================");
            out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                out.println("\nInvalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    out.printf("\nYour current balance is: %.2f EGP\n\n", account.getBalance());
                    break;
                case 2:
                    out.println();
                    account.depositMoney(scanner);
                    break;
                case 3:
                    out.println();
                    account.withdrawMoney(scanner);
                    break;
                case 4:
                    out.println("\nThank you for using Java Bank!");
                    break;
                default:
                    out.println("\nInvalid choice. Please try again.\n");
            }
        } while (choice != 4);

        scanner.close();
    }

}