package lab6_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("************************ Customers ********************************\n");

        Bank bank = new Bank("OTP");

        Customer customer1 = new Customer("Peter", "Hill");
        Customer customer2 = new Customer("John", "Kind");
        bank.addCustomers(customer1);
        bank.addCustomers(customer2);

        customer1.addAccount(new SavingsAccount(10));
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

        System.out.println("************************ After adding interest rate ***************************\n");

        for(int i = 1; i <= bank.numCustomers(); i++){
            ArrayList<String> accountNumbers = bank.getCustomers(i).getAccountNumbers();
            for(String s : accountNumbers){
                if(bank.getCustomers(i).getAccount(s) instanceof SavingsAccount){
                    ((SavingsAccount) bank.getCustomers(i).getAccount(s)).addInterest();
                }
            }
        }

        bank.printCustomersToStdout();

        System.out.println("*************** After withdrawing a random amount of money *********************\n");

        for(int i = 1; i <= bank.numCustomers(); i++){
            ArrayList<String> accountNumbers = bank.getCustomers(i).getAccountNumbers();
            for(String s : accountNumbers){
                bank.getCustomers(i).getAccount(s).withdraw(rand.nextInt(2000));
            }
        }

        bank.printCustomersToStdout();
    }
}
