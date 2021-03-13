package extra_exercise.models;

import extra_exercise.utils.Degree;
import extra_exercise.utils.Department;

public class Teacher {
    private String lastName;
    private final String firstName;
    private int teacherID;
    private Degree degree;
    private Department department;
    private static int currentNumberOfTeachers = 0;

    public Degree getDegree() {
        return degree;
    }

    private void generateID(){
        this.teacherID = ++currentNumberOfTeachers;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Teacher(String lastName, String firstName, String degree, String department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = Degree.create(degree);
        this.department = Department.create(department);
        generateID();
    }

    @Override
    public String toString() {
        return "Teacher: " + firstName + " " + lastName + " - " + degree + " from " + department + " department\n";
    }
}
