package lab3_1;

public class Customer {
    // each costumer is characterised by a first name, last name ad may have a single bank account
    private String firstName, lastName;
    private BankAccount account;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // set the account name
    public void setAccount(BankAccount account){
        if(account != null){
            this.account = account;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // return the attached account
    public BankAccount getAccount() {
        return account;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // sets the account attribute to null
    public void closeAccount(){
        this.account = null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}

