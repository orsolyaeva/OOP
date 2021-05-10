package lab12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baccalaureate {
    private Map<Integer, Student> students = new HashMap<>();

    public Baccalaureate(String filename){
        try(Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, " \t");

                int ID = Integer.parseInt(tokens.nextToken());
                String firstName = tokens.nextToken().replaceAll("\\s+", "");
                String lastName = tokens.nextToken().replaceAll("\\s+", "");

                students.put(ID, new Student(ID, firstName, lastName));
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("FILE NOT FOUND: " + filename);
        }
    }

    public void readGrades(String filename, int subject){
        try(Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, "\t ");

                int ID = Integer.parseInt(tokens.nextToken());

                Student student = this.students.get(ID);

                if(student != null){
                    switch (subject){
                        case 1 -> student.setMathematics(Double.parseDouble(tokens.nextToken()));
                        case 2 -> student.setHungarian(Double.parseDouble(tokens.nextToken()));
                        case 3 -> student.setRomanian(Double.parseDouble(tokens.nextToken()));
                    }
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("FILE NOT FOUND: " + filename);
        }
    }

    public void computeAverage(){
        for(Map.Entry<Integer, Student> student : students.entrySet()){
            student.getValue().setAverage();
        }
    }

    public void numberPassedStudents(){
        int countPassed = 0;
        for(Map.Entry<Integer, Student> student : students.entrySet()){
            if(student.getValue().isPassed()){
                countPassed += 1;
            }
        }

        System.out.println("Number of students who passed the exam: " + countPassed);
    }

    public void listFailedStudent(){
        System.out.println("List of students who failed the exam: ");
        for(Map.Entry<Integer, Student> student : students.entrySet()){
            if(!student.getValue().isPassed()){
                System.out.println(student);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        for(Map.Entry<Integer, Student> student : students.entrySet()){
            output.append("ID: " + student.getKey() + "\n");
            output.append("Name: " + student.getValue().getFullName() + "\n");
            output.append("Math: " + student.getValue().getMathematics() + "\n");
            output.append("Hungarian: " + student.getValue().getHungarian() + "\n");
            output.append("Romanian: " + student.getValue().getRomanian() + "\n\n");
        }

        return output.toString();
    }
}
