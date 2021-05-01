package lab9_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<MyDate> dates = new ArrayList<>();

        int year = 2021;
        while(dates.size() < 10){
            int month = rand.nextInt(13);
            int day = rand.nextInt(32);

            if(DateUtil.isValidDate(year, month, day)){
               dates.add(new MyDate(year, month, day));
            }
        }

        System.out.println("Array before sorting: ");
        dates.forEach(System.out::println);
        dates.sort(MyDate::compareTo);
        System.out.println("\nArray after sorting: ");
        dates.forEach(System.out::println);
    }
}
