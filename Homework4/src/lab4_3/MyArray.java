package lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// encapsulates an array of double values
public class MyArray {
    private double[] elements;
    private int length; // length of array

    public MyArray(String fileName){ // read data from file that contains the size and the elements
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!");
            length = 0;
            e.printStackTrace();
        }
        length = scanner.nextInt();
        this.elements = new double[length];
        for(int i = 0; i < length; i++){
            elements[i] = scanner.nextDouble();
        }

        scanner.close();
    }

    public MyArray(int length){ // creation of MyArray having a given length
        if(length >= 0){
            this.length = length;
            this.elements = new double[length];
        }
    }

    public MyArray(double[] array){ // creation of MyArray from a Java array double[]
        this.length = array.length;
        this.elements = new double[length];
        for(int i = 0; i < length; i++){
            this.elements[i] = array[i];
        }
    }

    public MyArray (MyArray array){ // creation of MyArray from an existing MyArray
        this.length = array.length;
        this.elements = new double[length];

        for(int i = 0; i < length; i++){
            this.elements[i] = array.elements[i];
        }
    }

    // fill the array with random numbers
    public void fillRandom(double minimum, double maximum){
        Random rand = new Random();
        for(int i = 0; i < this.length; i++){
            elements[i] = minimum + (maximum - minimum) * rand.nextDouble();
        }
    }

    // return the mean of the array
    public double mean(){
        if(elements.length == 0) {
            System.out.println("The array is empty!");
            return Double.NaN;
        }
        double mean = 0;
        for(double element:elements){
            mean += element;
        }
        return mean / elements.length;
    }

    // return the standard deviation of the array
    public double stddev(){
        if(elements.length == 0){
            System.out.println("The array is empty!");
            return -1; // if the given array is empty return a negative number, because the minimum possible standard deviation is zero
        }
        double stdDev = 0;
        double mean = mean();

        for(double element:elements){
            stdDev += Math.pow(element - mean, 2);
        }

        stdDev /= elements.length;
        stdDev = Math.sqrt(stdDev);

        return stdDev;
    }

    // sort the elements of the array
    public void sort(){
        Arrays.sort(this.elements);
    }

    // print the elements of the array
    public void print(String name){
        System.out.print(name + ": ");
        for(double element:elements){
            System.out.printf("%5.2f ", element);
        }
        System.out.println();
    }
}
