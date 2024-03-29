package lab5_1;

import java.util.ArrayList;

// this class is similar to the one in lab3_1 with the exception that now a customer can have more than one accounts
public class Customer {
    private String firstName, lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private final int id;
    private static int counter = 0;

    public Customer(String firstName, String lastName) {
        this.id = ++ counter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public ArrayList<String> getAccountNumbers(){
        ArrayList<String> accountNumbers = new ArrayList<>();
        for(BankAccount account : accounts){
            accountNumbers.add(account.getAccountNumber());
        }
        return accountNumbers;
    }

    public int getId() {
        return id;
    }

    // this method adds a new bank account
    public void addAccount(BankAccount account) {
        if (account == null) {
            return;
        }
        this.accounts.add(account);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // method to close an account and decrease the number of accounts
    public void closeAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " id: " + id + " accounts:\n");
        for (BankAccount account : accounts) {
            result.append("\t" + account.toString() + "\n");
        }
        return result.toString();
    }
}