package lab5_1;


public class BankAccount {
    private static int numAccounts = 0; // variable to count the number of account
    private double balance;
    private final String accountNumber;
    public static final String PREFIX = "OTP";
    public static int ACCOUNT_NUMBER_LENGTH = 10; // length of an account number

    // shadowing
    public BankAccount(){
        ++numAccounts;
        this.accountNumber = generateAccountNumber();
    }

    // method to generate the account numbers
    private static String generateAccountNumber(){
        StringBuffer str = new StringBuffer();
        String count = "" + numAccounts;
        str.append(PREFIX);
        for(int i = 0; i < ACCOUNT_NUMBER_LENGTH - PREFIX.length() - count.length(); i++){
            str.append('0');
        }
        str.append(numAccounts);
        return str.toString();
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }
        balance -= amount;
        return true;
    }

    public String toString(){
        return "Account number: " + accountNumber + " current balance: " + balance + "\n";
    }
}
