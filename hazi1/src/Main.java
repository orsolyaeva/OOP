import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of the exercise: ");
        int exercise = in.nextInt();
        switch (exercise){
            case 1: exercise1(); break;
            case 2: exercise2(); break;
            case 3: exercise3(); break;
            case 4: exercise4(); break; // exercise 1 from "Functions"
            case 5: exercise5(); break; // exercise 2 from "Functions"
            case 6: exercise6(); break;
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

        System.out.printf("The %dth bit of the given number: %d\n", position, getBit(number, position));
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

