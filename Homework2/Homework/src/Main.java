import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        exercise3();
//        Scanner in = new Scanner(System.in); // using Scanner for getting input from the User
//        while(true){
//            System.out.print("Enter the number of the exercise (to exit enter 13): ");
//            int exercise = in.nextInt();
//            switch (exercise){
//                case 1: exercise1(); break;
//                case 2: exercise2();
//                case 3: exercise3();
//                case 4: exercise4(); // the Extra exercise
//                case 5: System.exit(0); // exits while loop, terminate execution
//                default:
//                    System.out.println("Try again!");
//            }
//        }
    }

    public static void exercise1(){
        BankAccount account1 = new BankAccount("OTP00001"); // create a bank account
        System.out.println(account1.getAccountNumber() + ":" + account1.getBalance()); // print the account number and balance
        System.out.println("Deposit 1000 EUR.");
        account1.deposit(1000); // deposit 1000 EUR
        System.out.println(account1.getAccountNumber() + ":" + account1.getBalance());

        System.out.println("Withdraw 500 euro");
        boolean result = account1.withdraw(500);
        if (!result){
            System.out.println("You do not have sufficient funds for this operation!");
        }
        System.out.println(account1.getAccountNumber() + ":" + account1.getBalance());

        System.out.println("Withdraw 1000 euro");
        result = account1.withdraw(1000);
        if (!result){
            System.out.println("You do not have sufficient funds for this operation!");
        }
        System.out.println(account1.getAccountNumber() + ":" + account1.getBalance());

        // create a second bank account
        BankAccount account2 = new BankAccount("OTP00002");
        System.out.println(account2.getAccountNumber() + ":" + account2.getBalance());
        System.out.println("Deposit 2000 EUR.");
        account2.deposit(2000);
        System.out.println(account2.getAccountNumber() + ":" + account2.getBalance());
    }

    public static void exercise2(){
        Rectangle[] rectangles = new Rectangle[10];
        Random rand = new Random();

        for(int i = 0; i < rectangles.length; i++){
            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10);
            rectangles[i] = new Rectangle(length, width);
        }

        double totalArea = 0;
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n", "Rectangle", "length", "width", "Perimeter", "Area");
        for(int i = 0; i < rectangles.length; i++){
            System.out.format("%-15d%-15.2f%-15.2f%-15.2f%-15.2f\n", i, rectangles[i].getLength(), rectangles[i].getWidth(), rectangles[i].perimeter(), rectangles[i].area());
            totalArea += rectangles[i].area();
        }

        System.out.format("\n%-15s%-15s%-15s%-15s%.2f\n", "", "", "", "Total area  =", totalArea);
    }

    public static void exercise3(){
        int countInvalidDate = 0; // variable to count the number of invalid dates generated
        Random rand = new Random();
        MyDate date;

        // generate 1000 random dates, print out the valid ones
        for(int i = 0; i < 1000; i++){
            int year = rand.nextInt(2022);
            int month = rand.nextInt(15);
            int day = rand.nextInt(40);
            date = new MyDate(year, month, day);
            if(date.getYear() == 0 || date.getMonth() == 0 || date.getDay() == 0){
                countInvalidDate += 1;
            }
            else{
                System.out.println(date.toString());
            }
        }
        System.out.println("Number of invalid dates: " + countInvalidDate);
    }
}

