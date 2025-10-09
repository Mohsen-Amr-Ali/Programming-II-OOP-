public class BankAccount {
    //-------- members -------//
    private int account_num;
    private String account_holder;
    private double balance;

    //------- constructors -------//
    BankAccount(){}

    BankAccount(int account_num, String account_holder){
        this.account_num = account_num;
        this.account_holder = account_holder;
        this.balance = 0;
    }

    //------- getters & setters------//
}
