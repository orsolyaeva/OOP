package lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        readFilePrintItsLineNumbered("Homework4/lab4_1_input.txt");

        ArrayList<Person> persons = new ArrayList<>();
        persons = readFromCSVFile("Homework4/lab4_1_input.csv");
        for(Person person:persons){
            System.out.println(person);
        }
    }

    // method that reads the lines of a text file and prints them
    public static void readFilePrintItsLineNumbered(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(("An error occurred whilst reading the file."));
            System.exit(1);
        }
        int nrLine = 1;
        String line;
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            System.out.println(nrLine + ". " + line);
            nrLine += 1;
        }
    }

    // method that reads data from the CSV file, creating the Person object
    public static ArrayList<Person> readFromCSVFile(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(("An error occurred whilst reading the file."));
            System.exit(2);
        }

        ArrayList<Person> persons = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[]  items = line.split(",");
            String firstName = items[0].trim();
            String lastName = items[1].trim();
            int birtYear = Integer.parseInt(items[2].trim());
            persons.add(new Person(firstName, lastName, birtYear));
        }

        return persons;
    }
}
