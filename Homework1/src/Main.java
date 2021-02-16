import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); // using Scanner for getting input from the User
        System.out.println("Enter the number of the exercise: ");
        int exercise = in.nextInt();
        switch (exercise){
            case 1: exercise1(); break;
            case 2: exercise2(); break;
            case 3: exercise3(); break;
            case 4: exercise4(); break;
            case 5: exercise5(); break; // exercise 1 from "Functions"
            case 6: exercise6(); break; // exercise 2 from "Functions"
            case 7: exercise7(); break; // exercise 3 from "Functions"
            case 8: exercise8(); break; // exercise 4 from "Functions"
            case 9: exercise9(); break; // exercise 5 from "Functions"
            case 10: exercise10(); break; // exercise 6 from "Functions"
            default:
                System.out.println("Try again!");
        }
    }

    public static void exercise1(){
        System.out.println("Nyitrai Orsi, Nagyenyed, Matematika-Informatika, Bethlen Gabor");
    }


    public static void exercise2(){
        String name = "Nyitrai Orsolya";
        String monogram = "Ny" + "O";
        for(int i = 0; i < name.length(); i++){
            System.out.println(name.charAt(i));
        }
        System.out.println(monogram);
    }


    public static void exercise3(){
        String str = "ALMAFA";
        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j <= i; j++){
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }


    public static void exercise4(){
        String name =  "Kerekes Balint Adam Jozsef";
        String[] words = name.split(" ");
        String monogram = "";

        for(String word: words){
            System.out.println(word);
            monogram += word.charAt(0);
        }
        System.out.print(monogram);
    }


    public static void exercise5(){ // exercise 1 from "Functions"
        double x[] = {7, 1, -3, 45, 9};
        System.out.printf("MAX: %6.2f\n", maxElement(x));

//        double y[] = {};
//        System.out.printf("MAX: %6.2f\n", maxElement(y));
//
//        double z[] = null;
//        System.out.printf("MAX: %6.2f\n", maxElement(z));
    }


    public static void exercise6(){ // exercise 2 from "Functions"
        Scanner read = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = read.nextInt();

        System.out.print("Enter the position: "); // which bit you want to check
        int position = read.nextInt();

        int bit = getBit(number, position);

        if(bit == -1){
            System.out.println("The given position is out of range! Enter a position between 0 and 7.");
        }
        else{
            System.out.printf("The %dth bit of the given number: %d\n", position, bit);
        }
    }


    public static void exercise7(){ // exercise 3 from "Functions"
        System.out.printf("%5s %5s\n", "Number", "Set bits");
        for(int i = 0; i <= 31; i++){
            System.out.printf("%4d %5d\n", i,  countBits(i));
        }
    }


    public static void exercise8(){ // exercise 4 from "Functions"
        double x[] = {7.5, 1.4, -3, 45.3, 9};
        System.out.printf("The average of the array is: %.2f\n", mean(x));
    }


    public static void exercise9(){ // exercise 5 from "Functions"
        double x[] = {1, 4, 7, 2, 6};
        System.out.printf("Standard deviation = %.2f", stddev(x));
    }


    public static void exercise10(){ // exercise 6 from "Functions"
        double x[] = {7.5, 1.4, -3, 45.3, 9, 45.3, 22.1};

        double max[] = maximum(x);

        System.out.printf("The two largest numbers in the array: %.2f and %.2f.", max[0], max[1]);
    }


    public static double[] maximum(double array[]){
        double max[] = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};

        if(array.length == 0){
            return max;
        }

        if(array.length == 1){ // if the array contains only 1 number
            max[0] = array[0];
            max[1] = array[0];
            return max;
        }

        max[0] = array[0]; // second largest element
        max[1] = array[1]; // largest element

        if(max[0] > max[1]){
            double temp = max[0];
            max[0] = max[1];
            max[1] = temp;
        }


        for(int i = 2; i < array.length; i++){
            if(array[i] > max[1]){ // if the next element is larger then the actual largest element
                max[0] = max[1];
                max[1] = array[i];
            }

            else if(array[i] > max[0] && array[i] != max[1]){ // if the number is larger then the second largest element and it's different from the largest
                max[0] = array[i];
            }
        }

        return max;
    }

    public static double stddev(double array[]){ // function that returns the standard deviation of an array
        double mean = 0;
        double sD = 0; // Standard Deviation

        for(int i = 0; i < array.length; i++){
            mean += array[i];
        }

        mean /= array.length; // find the mean

        for(int i = 0; i < array.length; i++) { // for each data point, find the square of its distance to the mean and sum the values
            sD += Math.pow(array[i] - mean, 2);
        }

        sD /= array.length; // divide by the number of data points

        sD = Math.sqrt(sD); // take the square root

        return sD;
    }


    public static double mean(double array[]){ // function that return the average of an array
        if(array == null){
            return Double.NaN; // if the array does not exist
        }

        double average = 0;
        for(int i = 0; i < array.length; i++){
            average += array[i]; // count the sum of elements
        }

        average /= array.length; // divide the sum by the number of the elements

        return average;
    }

    public static int countBits(int number){
        int count = 0; // variable to count the number of set bits (number of 1 bits)

        while(number > 0){
            count += number & 1; // if the bit is set increment the set bit count
            number >>= 1; // shift the number by one bit to the right
        }

        return count;
    }

    public static byte getBit(int number, int pos){
        if(pos < 0 || pos > 7){ // if the given position is out of range
            return -1;
        }
        int mask = (number >> pos) & 1;
        return (byte) mask;
    }

    public static double maxElement(double array[]) {
        double max = Double.NEGATIVE_INFINITY;
        if(array == null){
            System.out.println("The array does not exist!");
            return max;
        }
//        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}

