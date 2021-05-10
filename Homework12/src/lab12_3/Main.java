package lab12_3;

// use HashMap

public class Main {
    public static void main(String[] args) {
        Baccalaureate baccalaureate = new Baccalaureate("Homework12/nevek1.txt");

        baccalaureate.readGrades("Homework12/matek.txt", 1);
        baccalaureate.readGrades("Homework12/magyar.txt", 2);
        baccalaureate.readGrades("Homework12/roman.txt", 3);

        baccalaureate.computeAverage();

        baccalaureate.numberPassedStudents();
        System.out.println();
        baccalaureate.listFailedStudent();
    }
}
