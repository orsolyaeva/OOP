package lab5_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
       ArrayList<BankAccount> bankAccounts = new ArrayList<>();
       for(int i = 0; i < 150; i++){
           bankAccounts.add(new BankAccount());
       }

       ArrayList<Customer> customers = new ArrayList<>();
       customers.add(new Customer("John", "Black"));
       customers.add(new Customer("Steve", "Brown"));
       customers.add(new Customer("Mary", "White"));

       for(int i = 0; i < customers.size(); i++){
           customers.get(customers.size()-1).addAccount(new BankAccount());
       }

       System.out.println(customers);

       Bank bank = new Bank("OTP");

       Customer customer1 = new Customer("Peter", "Hill");
       Customer customer2 = new Customer("John", "Kind");
       bank.addCustomers(customer1);
       bank.addCustomers(customer2);

       for(int i = 0; i < 2; i++){
           customer1.addAccount(new BankAccount());
           customer2.addAccount(new BankAccount());
       }

       System.out.println(bank.getCustomers(1).toString());

       Random rand = new Random();
        for(int i = 1; i <= bank.numCustomers(); i++){
            ArrayList<String> accountNumbers = bank.getCustomers(i).getAccountNumbers();
            for(String s : accountNumbers){
                bank.getCustomers(i).getAccount(s).deposit(rand.nextDouble() + 100);
            }
        }

        System.out.println(bank.getCustomers(2).toString());

        bank.printCustomersToFile("bank_customers_csv");
    }
}
