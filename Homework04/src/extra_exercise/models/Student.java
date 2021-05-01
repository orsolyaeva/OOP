package extra_exercise.models;

import extra_exercise.utils.Major;

public class Student {
    private final String neptuneCode, firstName, lastName;
    private final Major major; // each student belongs to a particular major

    public String getNeptuneCode(){
        return neptuneCode;
    }

    public Major getMajor(){
        return major;
    }

    public Student(String neptuneCode, String firstName, String lastName, String major) {
        this.neptuneCode = neptuneCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = Major.create(major);
    }

    public String toString() {
        return firstName + " " + lastName + " (" + neptuneCode + ")\n";
    }
}
