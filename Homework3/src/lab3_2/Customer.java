package lab3_2;

import lab3_1.BankAccount;

// this class is similar to the one in lab3_1 with the exception that now a customer can have more than one accounts
public class Customer {
    private String firstName, lastName;
    private BankAccount[] account = new BankAccount[MAX_ACCOUNT];
    private int numAccounts;
    public static final int MAX_ACCOUNT = 10; // maximum number of accounts


    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    // this method adds a new bank account if the account array has less than MAX_ACCOUNTS elements
    public void addAccount(BankAccount account){
        if(account == null){
            return;
        }
        if(numAccounts == MAX_ACCOUNT){
            System.out.println("Can not add more accounts!");
            return;
        }
        this.account[numAccounts] = account;
        numAccounts++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount(String accountNumber) {
        for(int i = 0; i < numAccounts; i++){
            if(account[i].getAccountNumber().equals(accountNumber)){
                return account[i];
            }
        }
        return null;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // method to close an account and decrease the number of accounts
    public void closeAccount(String accountNumber){
        for(int i = 0; i < numAccounts; i++){
            if(account[i].getAccountNumber().equals(accountNumber)){
                account[i] = null;
                for(int j = i; j < numAccounts - 1; j++){
                    account[j] = account[j + 1];
                }
                break;
            }
        }
        numAccounts--;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for(int i = 0; i < numAccounts; i++){
            result.append("\t" + account[i].toString() + "\n");
        }
        return result.toString();
    }
}

