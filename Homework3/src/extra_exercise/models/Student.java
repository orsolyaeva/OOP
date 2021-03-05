package extra_exercise.models;

import extra_exercise.enums.Major;

public class Student {
    private String neptunCode, firstName, lastName;
    Major major; // each student belong to a particular major

    public String getNeptunCode() {
        return neptunCode;
    }

    public Major getMajor() {
        return major;
    }

    public Student(String neptunCode, String firstName, String lastName, Major major) {
        this.neptunCode = neptunCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + neptunCode + ")\n";
    }
}
