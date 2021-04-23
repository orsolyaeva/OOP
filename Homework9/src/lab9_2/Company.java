package lab9_2;

import lab9_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Company {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee e){
        this.employees.add(e);
    }

    public void hireAll(String fileName){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Could not open document: " + fileName);
            System.exit(1);
        }

        StringTokenizer tokens;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            tokens = new StringTokenizer(line, ", ");

            String firstName = tokens.nextToken();
            String lastName = tokens.nextToken();
            double salary = Double.parseDouble(tokens.nextToken());
            int year = Integer.parseInt(tokens.nextToken());
            int month = Integer.parseInt(tokens.nextToken());
            int day = Integer.parseInt(tokens.nextToken());

            if(tokens.countTokens() == 1){
               hire(new Manager(firstName, lastName, salary, new MyDate(year, month, day), tokens.nextToken()));
            } else{
                hire(new Employee(firstName, lastName, salary, new MyDate(year, month, day)));
            }
        }
    }

    public void fire(int position){
        employees.remove(position);
    }

    public void printAll(PrintStream ps){
        for(Employee employee : employees){
            ps.println(employee);
        }
    }

    public void printManagers(PrintStream ps){
        for(Employee employee : employees){
            if(employee instanceof Manager){
                ps.println(employee);
            }
        }
    }

    void sortByComparator(Comparator<Employee> comparator){
        Collections.sort(employees, comparator);
    }
}
