package lab6_1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    // method that returns the customer having the id equal to customerId
    public Customer getCustomers(int customerId) {
        for(Customer customer:customers){
            if(customer.getId() == customerId){
                return customer;
            }
        }
        return null;
    }

    // prints the customers to a stream
    private void printCustomer(PrintStream ps){
//        ps.println("ID, FirstName, Last Name, Number of bank account");
        for(Customer customer: customers){
            ps.println(customer.getId()+ ", " + customer.getFirstName() + " " + customer.getLastName());
                for(String accountNumber: customer.getAccountNumbers()){
                    ps.println("\t" + customer.getAccount(accountNumber));
                }
        }
    }

    public void printCustomersToStdout(){
        printCustomer(System.out);
    }

    public void printCustomersToFile( String filename ) {
        try {
            printCustomer(new PrintStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addCustomers(Customer customer){
        customers.add(customer);
    }

    public int numCustomers(){
        return customers.size();
    }

}
