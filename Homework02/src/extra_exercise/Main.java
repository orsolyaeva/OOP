package extra_exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // read the attributes of the car from a file (brand, type and year of manufacture)
        Random rand = new Random();
        File file = new File("Homework2/input.txt");
        Scanner scanner = new Scanner(file);
        int numberCars = Integer.parseInt(scanner.nextLine()); // number of cars in the file
        int i = 0;
        String line;
        ArrayList<Car> cars = new ArrayList<>(numberCars); // each element of the array is a new car
        while(scanner.hasNextLine() && i < numberCars){
            int fuelType = rand.nextInt(4);
            boolean passengers = rand.nextBoolean();
            line = scanner.nextLine();
            try{
                StringTokenizer tokens = new StringTokenizer(line, ", ");
                cars.add(new Car(tokens.nextToken(), tokens.nextToken(),fuelType, passengers, Integer.parseInt(tokens.nextToken())));
                System.out.println(cars.get(i).toString());
                i++;
            }
            catch(Exception e){
                System.out.println("An error occurred whilst adding a new car!");
            }
        }

        System.out.println("\n\nIt's time to travel!");
        Scanner read = new Scanner(System.in);

        int countDiesel = 0;  // variable to count the number of the diesel cars
        int countRedCars = 0; // variable to count the number of the red cars
        boolean reset = false; // boolean to check which car's kilometer resets first
        int firstReset = -1; // variable to store the index of the first car which mileage resets

        for(i = 0; i < numberCars; i++){
            System.out.println("\n" + cars.get(i).toString()); // print which car is moving
            System.out.println("Enter how many times you want to move the car: ");
            int increase = read.nextInt();
            boolean increaseSpeed = false; // boolean to check if a car has already reached the speed limit or not
            for(int j = 0; j  < increase; j++){
                int kilometers = 1 + rand.nextInt(50); // random generate the distance the car should travel
                if(cars.get(i).getNumberOfKilometers() + kilometers >= 200 && !reset){
                    firstReset = i;
                    reset = true;
                }
//                System.out.println("Moving the car " + kilometers + " kilometers.");
                cars.get(i).moveCar(kilometers);

                if(cars.get(i).getSpeed() + 10 > 180 && !increaseSpeed){ // check speed limit
                    System.out.println("You reached the speed limit! Stay safe!");
                    increaseSpeed = true;
                }
                else if (cars.get(i).getSpeed() + 10 <= 180 && !increaseSpeed){
                    // if it hasn't reached the speed limit yet, increase the speed with 10 km / h
                    cars.get(i).changeSpeed(10);
                }
            }

            System.out.println("The " + cars.get(i).getCarBrand() + " " +
                    cars.get(i).getCarType() + " has traveled " + cars.get(i).getNumberOfKilometers() +
                    " kilometers and reached the speed of " + cars.get(i).getSpeed() + "km/h.");

            // count the number of Diesel cars
            if(cars.get(i).getFuel() == FuelType.valueOf("DIESEL")){
                countDiesel += 1;
            }

            // count the number of red cars
            if(cars.get(i).getColor() == Color.valueOf("RED")){
                countRedCars += 1;
            }

        }
        System.out.println("\nThe kilometers for the car with the index number " + firstReset + " were reset first.");
        System.out.println("The number of red cars is " + countRedCars + ".");
        System.out.println("The number of diesel cars is " + countDiesel + ".");
    }
}


