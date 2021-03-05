package extra_exercise;

import extra_exercise.enums.Degree;
import extra_exercise.enums.Department;
import extra_exercise.enums.Major;
import extra_exercise.models.Course;
import extra_exercise.models.Student;
import extra_exercise.models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int MAX_COURSES = 50;
    public static Course[] courses = new Course[MAX_COURSES];
    private static int numberCourses = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Student student1 = new Student("AVLMO7", "Anne", "Bell", Major.INFORMATION_SCIENCE);
        Teacher teacher1 = new Teacher("Suzanne", "Grey", Degree.DOCENT, Department.MATHEMATICS_INFORMATICS);
        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        Student student2 = new Student("AVLMO8", "John", "Black", Major.HORTICULTURAL_ENGINEERING);
        Teacher teacher2 = new Teacher("Michael", "Grey", Degree.ADJUNCT, Department.ELECTRICAL_ENGINEERING);
        Course course2 = new Course("MB_INFO45", 7, DayOfWeek.MONDAY);

        Student student3 = new Student("AVLMI1", "David", "Pumpkin", Major.COMPUTER_SCIENCE);
        Teacher teacher3 = new Teacher("Marry", "Holmes", Degree.PROFESSOR, Department.MATHEMATICS_INFORMATICS);
        Course course3 = new Course("MB_INFO40", 6, DayOfWeek.WEDNESDAY);

        course1.setTeacher(teacher1);

        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student3);

        System.out.println(course1);

        File file = new File("Homework3/university.csv");
        Scanner scanner = new Scanner(file);
        int i = 1;
        String line;
        while(scanner.hasNextLine() && i <= 100){
            line = scanner.nextLine();
            try{
                StringTokenizer tokens = new StringTokenizer(line, ",");
                if(i % 2 != 0){
                    courses[numberCourses] = new Course(tokens.nextToken(), Integer.parseInt(tokens.nextToken()), DayOfWeek.of(Integer.parseInt(tokens.nextToken())));
                }
                else{
                    courses[numberCourses].setTeacher(new Teacher(tokens.nextToken(), tokens.nextToken(), Degree.valueOf(tokens.nextToken()), Department.values()[Integer.parseInt(tokens.nextToken()) - 1]));
                    numberCourses += 1;
                }
                i += 1;
            }
            catch(Exception e){
                System.out.println(e);
                System.out.println("An error occurred whilst adding a new course!");
            }
        }

        file = new File("Homework3/students.csv");
        scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            try{
                StringTokenizer tokens = new StringTokenizer(line, ",");
                Student student = new Student(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Major.valueOf(tokens.nextToken()));
                if(scanner.hasNextLine()){
                    line = scanner.nextLine();
                    tokens = new StringTokenizer(line, ",");
                    while(tokens.hasMoreTokens()){
                        String temp = tokens.nextToken();
                        for(i = 0; i < numberCourses; i++){
                            if(courses[i].getCourseID().equals(temp)){
                                courses[i].enrollStudent(student);
                                break;
                            }
                        }
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
                System.out.println("An error occurred whilst enrolling a new student!");
            }
        }

        for(Course course:courses){
            System.out.println(course);
        }
        System.out.println();

//        enrolledStudentsByMajor(Major.MANUFACTURING_ENGINEERING, "JUHXF");

//        ArrayList<Course> coursesDegree = coursesByTeacherDegree(Degree.PROFESSOR);
//        for (Course coursesD : coursesDegree){
//            System.out.println(coursesD);
//        }

        cancelEnrollments("Homework3/cancellation.csv");

        for(Course course:courses){
            System.out.println(course);
        }
        System.out.println();
    }

    public static void enrolledStudentsByMajor(Major major, String courseId) {
        for(int i = 0; i < numberCourses; i++){
            if(courses[i].getCourseID().equals(courseId)){
                Student[] students = courses[i].getEnrolledStudents();
                int length = courses[i].getNumberOfEnrolledStudents();
                for(int j = 0; j < length; j++){
                    if(students[j].getMajor() == major){
                        System.out.println(students[j]);
                    }
                }
                break;
            }
        }
    }

    public static ArrayList<Course> coursesByTeacherDegree(Degree degree){
        ArrayList<Course> courseDegree = new ArrayList<>();
        int courseDegreeLength = 0;
        for(int i = 0; i < numberCourses; i++){
            if(courses[i].getTeacher().getDegree().equals(degree)){
                courseDegree.add(courses[i]);
            }
        }
        return courseDegree;
    }

    public static int nrOfCoursesByDay(DayOfWeek day) {
        int countDays = 0;
        for (int i = 0; i < numberCourses; i++){
            if(courses[i].getDayOfCourse().equals(day)){
                countDays += 1;
            }
        }
        return countDays;
    }

    public static void cancelEnrollments(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String line;
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            for(int i = 0; i < numberCourses; i++){
                courses[i].cancelEnrollment(line);
            }
        }
    }
}