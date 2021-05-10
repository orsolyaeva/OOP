package lab9_3;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Storage storage = new Storage("Homework09/data1000000.txt");
        storage.update("Homework09/update1000000.txt");

        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;
        System.out.println("Execution time: " + timeElapsed);
    }
}
