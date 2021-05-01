package lab9_2;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Google");

        company.hireAll("Homework9/employees.csv");

        System.out.println("Before sorting:");
        company.printAll(System.out);

        System.out.println("\nAlphabetically sorted: ");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getLastName().compareTo(o2.getLastName());
                }

                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        company.printAll(System.out);

        System.out.println("\nDecreasing salary order: ");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
               return (int) (o2.getSalary() - o1.getSalary());
            }
        });
        company.printAll(System.out);


        // note: try to find a better solution
        System.out.println("\nManagers followed by employees, alphabetically: ");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
               if(o1.getClass().equals(o2.getClass())){
                   if(o1.getFirstName().equals(o2.getFirstName())){
                       return o1.getLastName().compareTo(o2.getLastName());
                   }

                   return o1.getFirstName().compareTo(o2.getFirstName());
               }

               if(o1 instanceof Manager){
                   return -1;
               }
               return 1;
            }
        });


        company.printAll(System.out);
    }
}
