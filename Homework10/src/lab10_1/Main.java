package lab10_1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        double sum = 0;

        System.out.print("Please enter a sentence: ");
        Scanner read = new Scanner(System.in);
        StringTokenizer tokens = new StringTokenizer(read.nextLine(), ",\t ");

        while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();
            try{
                sum += Double.parseDouble(token);
            } catch (NumberFormatException e){
                System.out.println(token + " is not an integer.");
            }
        }

        System.out.println("\nSum: " + sum);
    }
}
