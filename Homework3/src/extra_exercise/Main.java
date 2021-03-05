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

    public static int MAX_COURSES = 50; // variable to store the maximum number of students in a course
    public static Course[] courses = new Course[MAX_COURSES];
    private static int numberCourses = 0; // variable to count the number of courses

    public static void main(String[] args) throws FileNotFoundException {
        // create 3 students(different majors), 3 teachers (from different departments and with different degree) and one course
        Student student1 = new Student("AVLMO7", "Anne", "Bell", Major.INFORMATION_SCIENCE);
        Student student2 = new Student("AVLMO8", "John", "Black", Major.HORTICULTURAL_ENGINEERING);
        Student student3 = new Student("AVLMI1", "David", "Pie", Major.COMPUTER_SCIENCE);

        Teacher teacher1 = new Teacher("Suzanne", "Grey", Degree.DOCENT, Department.MATHEMATICS_INFORMATICS);
        Teacher teacher2 = new Teacher("Michael", "Grey", Degree.ADJUNCT, Department.ELECTRICAL_ENGINEERING);
        Teacher teacher3 = new Teacher("Marry", "Holmes", Degree.PROFESSOR, Department.APPLIED_LINGUISTICS);

        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        // assign the first teacher to the previously created course
        course1.setTeacher(teacher1);

        // add all three students to this course
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student3);

        System.out.println(course1);

        File file = new File("Homework3/university.csv");
        Scanner scanner = new Scanner(file);
        int nrRow = 1; // variable to store the number of the rows (actual row)
        String line;
        while(scanner.hasNextLine() && nrRow <= 100){
            line = scanner.nextLine();
            try{
                StringTokenizer tokens = new StringTokenizer(line, ",");
                if(nrRow % 2 != 0){ // odd rows contain information about a specific course
                    courses[numberCourses] = new Course(tokens.nextToken(), Integer.parseInt(tokens.nextToken()), DayOfWeek.of(Integer.parseInt(tokens.nextToken())));
                }
                else{ // even rows contain information about the teacher taking the course
                    courses[numberCourses].setTeacher(new Teacher(tokens.nextToken(), tokens.nextToken(), Degree.valueOf(tokens.nextToken()), Department.values()[Integer.parseInt(tokens.nextToken()) - 1]));
                    numberCourses += 1;
                }
                nrRow += 1;
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
                // store the information about a student
                Student student = new Student(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Major.valueOf(tokens.nextToken()));
                if(scanner.hasNextLine()){
                    line = scanner.nextLine();
                    tokens = new StringTokenizer(line, ",");
                    while(tokens.hasMoreTokens()){
                        String temp = tokens.nextToken(); // variable to store a course's ID
                        for(int i = 0; i < numberCourses; i++){
                            if(courses[i].getCourseID().equals(temp)){ // if the course exists
                                courses[i].enrollStudent(student); // enroll student
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

        // print all courses
        for(Course course:courses){
            System.out.println(course);
        }
        System.out.println();

        // print all student with a specific major enrolled to a course
        enrolledStudentsByMajor(Major.MANUFACTURING_ENGINEERING, "JUHXF");

        // return an array containing all courses which are held by a teacher with a given degree
        ArrayList<Course> coursesDegree = coursesByTeacherDegree(Degree.PROFESSOR);
        for (Course coursesD : coursesDegree){
            System.out.println(coursesD);
        }

        // count the number of courses which are held on a given day
        System.out.println(nrOfCoursesByDay(DayOfWeek.MONDAY));

        cancelEnrollments("Homework3/cancellation.csv");

        // cancel the enrollment of a student from all courses
        for(Course course:courses){
            System.out.println(course);
        }
        System.out.println();
    }

    // method to print all students with a specific major enrolled to a course
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

    // method to return an array containing all courses which are held by a teacher with a given degree
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

    // method to count the number of courses which are held on a given day
    public static int nrOfCoursesByDay(DayOfWeek day) {
        int countDays = 0;
        for (int i = 0; i < numberCourses; i++){
            if(courses[i].getDayOfCourse().equals(day)){
                countDays += 1;
            }
        }
        return countDays;
    }

    // method the cancel the enrollment of a student from all courses
    public static void cancelEnrollments(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String line;
        while(scanner.hasNextLine()) {
            try {
                line = scanner.nextLine();
                for (int i = 0; i < numberCourses; i++) {
                    courses[i].cancelEnrollment(line);
                }
            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("An error occurred whilst cancelling a student's enrollment.");
            }
        }
    }
}