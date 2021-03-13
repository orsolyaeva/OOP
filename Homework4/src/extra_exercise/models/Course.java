package extra_exercise.models;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Course {
    private final String courseID;
    private final int numberOfCredits;
    private Teacher teacher; // assigning one teacher to each class
    private final DayOfWeek dayOfCourse; // the day of the week when the course occurs
    private final ArrayList<Student> enrolledStudents = new ArrayList<>(); // the list of enrolled student to a course

    public String getCourseID() {
        return courseID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int numberOfStudents(){
        return this.enrolledStudents.size();
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // method to cancel the enrollment of a student
    public void cancelEnrollment(String studentID){
        for(Student stud:enrolledStudents){
            if(stud.getNeptuneCode().equals(studentID)){
                enrolledStudents.remove(stud);
                break;
            }
        }
    }

    // method to enroll a student
    public void enrollStudent(Student student){
        if(student != null){
            enrolledStudents.add(student);
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
        strBuilder.append("\tEnrolled students: \n");
        for(Student stud:enrolledStudents){
            strBuilder.append("\t\t- " + stud.toString());
        }
        return strBuilder.toString();
    }
}
