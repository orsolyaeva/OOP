package extra_exercise.models;

import java.time.DayOfWeek;
import java.util.Arrays;

public class Course {
    private String courseID;
    private int numberOfCredits, numberOfEnrolledStudents = 0;
    Teacher teacher; // assigning one teacher to each class
    DayOfWeek dayOfCourse; // the day of the week when the course occurs
    public static int MAX_STUDENTS = 120; // maximum number of student in a course
    Student[] enrolledStudents = new Student[MAX_STUDENTS]; // the list of enrolled student to a course

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getNumberOfEnrolledStudents() {
        return numberOfEnrolledStudents;
    }

    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // method to cancel the enrollment of a student
    public void cancelEnrollment(String studentID){
        for(int i = 0; i < numberOfEnrolledStudents; i++){
            if(enrolledStudents[i].getNeptunCode().equals(studentID)){
                System.arraycopy(enrolledStudents, i + 1, enrolledStudents, i, enrolledStudents.length - i - 1);
                numberOfEnrolledStudents -= 1;
            }
        }
    }

    // method to enroll a student
    public void enrollStudent(Student student) {
        if (numberOfEnrolledStudents < MAX_STUDENTS && student != null) {
            enrolledStudents[numberOfEnrolledStudents] = student;
            numberOfEnrolledStudents += 1;
        }
    }

    public Course(String courseID, int numberOfCredits, DayOfWeek dayOfCourse) {
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfCourse = dayOfCourse;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Course: " + courseID + ": \n");
        strBuilder.append("\t" + teacher.toString());
        strBuilder.append("\tCredits: " + numberOfCredits + "\n");
        strBuilder.append("\tOccurs every: " + dayOfCourse + "\n");
        strBuilder.append("\tEnrolled students: " + numberOfEnrolledStudents + "\n");
        for(int i = 0; i < numberOfEnrolledStudents; i++){
            strBuilder.append("\t\t- " + enrolledStudents[i].toString());
        }
        return strBuilder.toString();
    }
}
