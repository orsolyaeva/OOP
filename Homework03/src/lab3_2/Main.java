package lab3_2;

import lab3_1.BankAccount;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Customer customer1 = new Customer("John", "BLUE");
        Customer customer2 = new Customer("Mary", "RED");
        Random rand = new Random();
        int money;
        for(int i = 1; i <= 9; i++){
            money = rand.nextInt(1000); // deposit in each account a random amount of money
            String accountNumber = "OTP0000" + i;
            if(i <= 5){
                customer1.addAccount(new BankAccount(accountNumber));
                customer1.getAccount(accountNumber).deposit(money);
            }
            money = rand.nextInt(1000);
            customer2.addAccount(new BankAccount(accountNumber));
            customer2.getAccount(accountNumber).deposit(money);
        }

        System.out.println(customer1.toString());
        System.out.println(customer2.toString());

        // close the first account of the first customer
        customer1.closeAccount("OTP00001");
        System.out.println(customer1.toString());

        // close the last account of the second customer
        customer2.closeAccount("OTP00009");
        System.out.println(customer2.toString());
    }
}
