package lab6_1;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(){
        this.balance += (this. balance * (this.interestRate / 100));
    }

    @Override
    public String toString() {
        return "SavingsAccount:\n\t\t- interestRate = " + this.interestRate + "\n\t\t- accountNumber: " + accountNumber;
    }
}
