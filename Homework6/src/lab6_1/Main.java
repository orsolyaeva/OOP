package lab6_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("OTP");

        Customer customer1 = new Customer("Peter", "Hill");
        Customer customer2 = new Customer("John", "Kind");
        bank.addCustomers(customer1);
        bank.addCustomers(customer2);

        customer1.addAccount(new SavingsAccount(3));
        customer1.addAccount(new CheckingAccount(1200));

        customer2.addAccount(new SavingsAccount(5));
        customer2.addAccount(new CheckingAccount(500));


        Random rand = new Random();
        for(int i = 1; i <= bank.numCustomers(); i++){
            ArrayList<String> accountNumbers = bank.getCustomers(i).getAccountNumbers();
            for(String s : accountNumbers){
                bank.getCustomers(i).getAccount(s).deposit(rand.nextInt(1000));
            }
        }

        bank.printCustomersToStdout();

    }
}
