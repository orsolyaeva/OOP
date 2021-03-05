package extra_exercise.models;

import extra_exercise.enums.Degree;
import extra_exercise.enums.Department;

public class Teacher {
    private String lastName, firstName;
    private int teacherID;
    Degree degree;
    Department department;
    public static int currentNumberOfTeachers = 0;

    public Degree getDegree() {
        return degree;
    }

    public Teacher(String lastName, String firstName, Degree degree, Department department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = degree;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Teacher: " + firstName + " " + lastName + " - " + degree + " from " + department + " department\n";
    }
}
