package lab11_1;

import java.util.Random;

public class AddToArray extends Thread{
    private String[] sa_array;
    public static final int changeMax = 300;
    public static int countChanges = 0;

    public AddToArray(String[] sa_array) {
        this.sa_array = sa_array;
    }

    @Override
    public void run() {
        Random rand = new Random();
        char random_char;

        while(countChanges < changeMax){
            synchronized (sa_array){
                int num = rand.nextInt(26);
                random_char = (char)(97 + num);

                String characters = "" + random_char + random_char + random_char;

                this.sa_array[minimumPosition(characters)] = characters;
                countChanges += 1;

                printArray();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped running.");
        this.interrupt();
//        System.exit(0);
    }

    private int minimumPosition(String characters){
        int position = 0, smallestDifference = 0;

        for(int i = 0; i < sa_array.length; i++){
            if(sa_array[i].compareTo(characters) < smallestDifference) {
                smallestDifference = sa_array[i].compareTo(characters);
                position = i;
            }
        }

        return position;
    }

    public void printArray(){
        System.out.print(Thread.currentThread().getName() + ": ");
        for(String s : sa_array){
            System.out.print(s + " ");
        }

        System.out.println();
    }
}
