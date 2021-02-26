import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//	    Car car = new Car("Ford", "Fiesta", 2, true, 2002);
	    boolean ok = false;
        int countDiesel = 0, countRedCars = 0;
//        System.out.println(car);
        try{
            File file = new File("input.txt");
            Scanner myReader = new Scanner(file);
            int nrCars = myReader.nextInt();
            myReader.nextLine();
            ArrayList<Car> cars = new ArrayList<>(nrCars);
            Random rand = new Random();
            for(int i = 0; i < nrCars; i++) {
                int fuelType = rand.nextInt(3);
                boolean passengers = rand.nextBoolean();
                String carType = myReader.nextLine();
                String carBrand = myReader.nextLine();
                String yearManufacture = myReader.nextLine();
                int year = Integer.parseInt(yearManufacture);

                if(fuelType == 0){
                    countDiesel += 1;
                }

                if(carType.charAt(0) == 'R'){
                    countRedCars += 1;
                }

                cars.add(new Car(carType, carBrand, fuelType, passengers, year));

                int increase;
                Scanner read = new Scanner(System.in);
                System.out.println("Enter how many times to increase the speed: ");
                increase = read.nextInt();
                for(int j = 0; j < increase; j++) {
                    int kilometer = 1 + rand.nextInt(50);
                    System.out.println(kilometer);
                    cars.get(i).moveCar(kilometer);
                    if(cars.get(i).getSpeed() + 10 > 180){
                        System.out.println("You can not increase the speed more! Stay safe!");
                    }
                    else{
                        cars.get(i).changeSpeed(10);
                    }
                    if(cars.get(i).getNumberOfKilometers() == 0 && !ok){
                        System.out.println("The first car whose kilometers resets for the first time is " + i);
                        ok = true;
                    }
                    System.out.println(cars.get(i).toString());
                }

            }
            System.out.println("The number of diesel cars is " + countDiesel);
            System.out.println("The number of red cars is " + countDiesel);
            myReader.close();
            }catch(FileNotFoundException e){
                System.out.println("An error occurred. Can not open the file!");
                e.printStackTrace();
             }
        }
}


