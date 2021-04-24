package lab9_3;

import java.awt.*;
import java.util.ArrayList;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Storage storage = new Storage("Homework9/data1000000.txt");
        storage.update("Homework9/update1000000.txt");

        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;
        System.out.println("Execution time: " + timeElapsed);
    }
}
