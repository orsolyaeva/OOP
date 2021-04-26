package lab10_2;

public class Student {
    private final String neptunID, firstName;
    private String lastName;
    private final MyDate birthDate;

    public Student(String neptunID, String firstName, String lastName, MyDate birthDate) {
        this.neptunID = neptunID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "neptunID='" + neptunID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
