package lab6_1;

public class CheckingAccount extends BankAccount{
    private double overdraftLimit;

    public CheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount){
        if(amount > balance + overdraftLimit){
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "CheckingAccount:\n" + "\t\t- balance: " + balance +"\n\t\t- accountNumber: " + accountNumber
                + "\n\t\t- overdraftLimit: " + overdraftLimit + "\n";
    }
}
