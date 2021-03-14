package extra_exercise;

import extra_exercise.models.Course;
import extra_exercise.models.Student;
import extra_exercise.models.Teacher;
import extra_exercise.utils.Degree;
import extra_exercise.utils.Department;
import extra_exercise.utils.Major;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static final ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args){
        // initializing the Degree, Deparmtent and Major classes with the values from the previous exercise (lab 3)
        initializeUtils();

        Student student1 = new Student("AVLMO7", "Anne", "Bell", "Dentistry");
        Student student2 = new Student("HGC54", "David", "Hill", "Biochemistry");
        Student student3 = new Student("ARFG7", "Peter", "Porto","Accounting");
        Student student4 = new Student("KGH43A", "Michael", "Monro", "Neuroanatomy");
        Student student5 = new Student("MFKSI4", "Sylvia", "Houston","Journalism");

        Teacher teacher1 = new Teacher("Suzanne", "Grey", "Labor technician", "Medical");
        Teacher teacher2 = new Teacher("John", "Fisher",  "Lecturer", "Literature");

        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        course1.setTeacher(teacher1);
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student3);
        course1.enrollStudent(student4);
        course1.enrollStudent(student5);

        System.out.println(course1);

        // read information about university courses
        readUniversity("Homework4/university.csv");

        // enroll students to specific courses
        readStudentsEnrollment("Homework4/students.csv");

        // print all student with a specific major enrolled to a course
        enrolledStudentsByMajor(Major.valueOf("MANUFACTURING_ENGINEERING"), "KL737");

        // print an array containing all courses which are held by a teacher with a given degree
        System.out.println(coursesByTeacherDegree(Degree.valueOf("ADJUNCT")));

        // print the number of courses held on a given day
        System.out.println(nrOfCoursesByDay(DayOfWeek.MONDAY));

        // cancel enrollments of given student
        cancelEnrollments("Homework4/cancellation.csv");

        // print all courses
        for(Course course : courses){
            System.out.println(course);
        }
    }

    // method to initialize the Degree, Department and Major ArrayLists
    public static void initializeUtils(){
        Degree.addList(new String[] {"ASSISTANT", "ADJUNCT", "PROFESSOR", "DOCENT"});
        Major.addList( new String[] {"AUTOMATION_AND_APPLIED_INFORMATICS", "COMMUNICATION_AND_PUBLIC_RELATIONS",
                "COMPUTER_SCIENCE", "HORTICULTURAL_ENGINEERING", "INFORMATION_SCIENCE", "LANDSCAPE_ARCHITECTURE",
                "MANUFACTURING_ENGINEERING", "MECHATRONICS", "PUBLIC_HEALTH_SERVICES_AND_POLICIES", "TELECOMMUNICATION",
                "TRANSLATION_AND_INTERPRETING_STUDIES"});
        Department.addList( new String[] {"APPLIED_LINGUISTICS", "APPLIED_SOCIAL_SCIENCE",
                "ELECTRICAL_ENGINEERING", "HORTICULTURE", "MATHEMATICS_INFORMATICS", "MECHANICAL_ENGINEERING"});
    }

    // method that reads data from the CSV file, creating the Course object
    public static void readUniversity(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(("An error occurred whilst reading the file."));
            System.exit(1);
        }

        int nrRow = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[]  items = line.split(",");
            if(nrRow % 2 != 0){
                courses.add(new Course(items[0].trim(), Integer.parseInt(items[1].trim()), DayOfWeek.of(Integer.parseInt(items[2].trim()))));
            }
            else{
                courses.get(courses.size() - 1).setTeacher(new Teacher(items[0].trim(), items[1].trim(),
                        items[2].trim(), items[3].trim().replace( " department", "")));
            }
            nrRow += 1;
        }
    }

    // method to read the enrolled student from a CSV file
    public static void readStudentsEnrollment(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(("An error occurred whilst reading the file."));
            System.exit(1);
        }

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[]  items = line.split(",");
            Student student = new Student(items[0].trim(), items[1].trim(), items[2].trim(), items[3].trim());
            if(scanner.hasNextLine()){
                line = scanner.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, ",");
                while(tokens.hasMoreTokens()){
                    String temp = tokens.nextToken();
                    for(Course course:courses){
                        if (course.getCourseID().equals(temp)){
                            course.enrollStudent(student);
                            break;
                        }
                    }
                }
            }
        }
    }

    // method to print all students with a specific major enrolled to a course
    public static void enrolledStudentsByMajor(Major major, String courseId){
        for(Course course: courses){
            if(course.getCourseID().equals(courseId)){
                ArrayList<Student> students = course.getEnrolledStudents();
                for(Student stud: students){
                    if(stud.getMajor().getName().equals(major.getName())){
                        System.out.println(stud);
                    }
                }
            }
        }
    }

    // method to return an array containing all courses which are held by a teacher with a given degree
    public static ArrayList<Course> coursesByTeacherDegree(Degree degree){
        ArrayList<Course> courseDegree = new ArrayList<>();
        for(Course course: courses){
            if(course.getTeacher().getDegree().getName().equals(degree.getName())){
                courseDegree.add(course);
            }
        }

        return courseDegree;
    }

    // method to count the number of courses which are held on a given day
    public static int nrOfCoursesByDay(DayOfWeek day) {
        int countDays = 0;
        for(Course course: courses){
            if(course.getDayOfCourse().equals(day)){
                countDays += 1;
            }
        }
        return countDays;
    }

    // method to cancel the enrollment of a student from all courses
    public static void cancelEnrollments(String fileName) {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(("An error occurred whilst reading the file."));
            System.exit(2);
        }

        int count = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for(Course course:courses){
                course.cancelEnrollment(line);
            }
        }
        System.out.println(count);
    }
}

