package lab12_3;

import java.util.Map;

public class Student {
    private final int ID;
    private final String firstName, lastName;
    private double hungarian, romanian, mathematics, average;
    private boolean passed;

    public Student(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public double getHungarian() {
        return hungarian;
    }

    public void setHungarian(double hungarian) {
        this.hungarian = hungarian;
    }

    public double getRomanian() {
        return romanian;
    }

    public void setRomanian(double romanian) {
        this.romanian = romanian;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage() {
       this.average = (this.mathematics + this.hungarian + this.romanian) / 3;
       this.setPassed();
    }

    public boolean isPassed() {
        return passed;
    }

    private void setPassed() {
        if(this.mathematics < 5 || this.hungarian < 5 || this.romanian < 5 || this.average < 6){
            this.passed = false;
        } else {
            this.passed = true;
        }
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        output.append("ID: " + this.ID + "\n");
        output.append("Name: " + this.getFullName() + "\n");
        output.append("Math: " +this.mathematics + "\n");
        output.append("Hungarian: " + this.hungarian + "\n");
        output.append("Romanian: " + this.romanian + "\n\n");

        return output.toString();
    }
}
