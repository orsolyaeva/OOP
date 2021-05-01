package lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Create ArrayList of costumers
        ArrayList<Customer> customers = readFile("Homework4/lab4_2_input.txt");

        // print the array to the standard output
        for(Customer customer: customers){
            System.out.println(customer);
        }
    }

    // fill the array with data read from the file
    public static ArrayList<Customer> readFile(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("An error occurred whilst reading the file.");
            System.exit(1);
        }

        ArrayList<Customer> customers = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split(",");
            try {
                if (items[0].trim().equals("Customer")) {
                    customers.add(new Customer(items[1].trim(), items[2].trim()));
                } else {
                    customers.get(customers.size() - 1).addAccount(new BankAccount(items[1].trim()));
                    customers.get(customers.size() - 1).getAccount(items[1].trim()).deposit(Integer.parseInt(items[2].trim()));
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println(line + " invalid row");
            }
        }
        return customers;
    }
}
