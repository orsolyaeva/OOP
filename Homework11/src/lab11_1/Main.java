package lab11_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       String[] sa_array = new String[10];
       Arrays.fill(sa_array, " ");

       Thread producer1 = new AddToArray(sa_array);
       Thread producer2 = new AddToArray(sa_array);
       Thread producer3 = new AddToArray(sa_array);
       Thread producer4 = new AddToArray(sa_array);

       Thread consumer1 = new TakeSomeFromArray(sa_array, "ppp", 10);
       Thread consumer2 = new TakeSomeFromArray(sa_array, "zzz", 15);
       Thread consumer3 = new TakeSomeFromArray(sa_array, "ooo", 34);

       producer1.start();
       consumer1.start();
       producer2.start();
       consumer2.start();
       producer3.start();
       consumer3.start();
       producer4.start();

    }
}
