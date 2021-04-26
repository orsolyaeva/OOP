package lab10_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            ps = new PrintStream("Homework10/warnings.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not open the file.");
            System.exit(1);
        }

        Scanner scanner = null;
        try{
            scanner = new Scanner(new File("Homework10/students.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(("An error occurred whilst reading the file."));
            System.exit(2);
        }

        StringTokenizer tokens;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            tokens = new StringTokenizer(line, ", ");
            if(tokens.countTokens() >= 7){
                while(tokens.hasMoreTokens()){
                    String code = tokens.nextToken();
                    String firstName = tokens.nextToken();
                    String lastName = tokens.nextToken();
                    int credits;

                    try{
                        credits = Integer.parseInt(tokens.nextToken());

                    } catch (NumberFormatException e){
                        System.out.println("NUMBER FORMAT EXCEPTION: " + line);
                        continue;
                    }

                    int birthYear, birthMonth, birthDay;
                    try{
                        birthYear = Integer.parseInt(tokens.nextToken());
                        birthMonth = Integer.parseInt(tokens.nextToken());
                        birthDay = Integer.parseInt(tokens.nextToken());

                    } catch (NumberFormatException e){
                        System.out.println("INVALID DATE: " + line);
                        continue;
                    }

                    if(!DateUtil.isValidDate(birthYear, birthMonth, birthDay)){
                        System.out.println("INVALID DATE: " + line);
                        continue;

                    } else {
                        if(credits < 30){
                            ps.println(line);
                        }
                    }

                }
            } else{
                System.out.println("INCOMPLETE LINE: " + line);
                continue;
            }
        }
    }

//
//    public static ArrayList<Student> readStudents(String filename){
//        ArrayList<Student> students = new ArrayList<>();
//        Scanner scanner = null;
//        try{
//            scanner = new Scanner(new File(filename));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println(("An error occurred whilst reading the file."));
//            System.exit(1);
//        }
//
//        StringTokenizer tokens;
//
//        while(scanner.hasNextLine()){
//            String line = scanner.nextLine();
//            tokens = new StringTokenizer(line, ", ");
//
//            if(tokens.countTokens() == 7){
//                while(tokens.hasMoreTokens()){
//                    String code = tokens.nextToken();
//                    String firstName = tokens.nextToken();
//                    String lastName = tokens.nextToken();
//
//
//                }
//            } else{
//                System.out.println("INCOMPLETE LINE: " + line);
//            }
//        }
//    }
}
