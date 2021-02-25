public class BankAccount {
    private double balance;
    private String accountNumber;

    // shadowing
    public BankAccount(String accountNumber){
        // accountNumber - local variable (parameter)
        this.accountNumber = accountNumber;
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
}

