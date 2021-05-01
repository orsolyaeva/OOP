package extra_exercise;

enum Color{
    RED('R'), GREEN('G'), BLUE('B'), BLACK('B'), WHITE('W');

    char first;
    Color(char f){
        first = f;
    }
    char getChar(){
        return first;
    }
}

enum FuelType{
    DIESEL(0), PETROL(1), GAS(2), ELECTRIC(3);

    int number;
    FuelType(int nr){
        number = nr;
    }
    int getNumber(){
        return number;
    }
}


public class Car {
    private String carBrand, carType;
    private Color color;
    private FuelType fuel;
    private int numberOfKilometers, numberOfPassengers, yearOfManufacture, speed;

    // constructor nr.1
    public Car(String carType, String carBrand, Color color, FuelType fuel, int numberOfKilometers, int numberOfPassengers, int yearOfManufacture, int speed){
        this.carType = carType;
        this.carBrand = carBrand;
        this.color = color;
        this.fuel = fuel;
        this.numberOfKilometers = numberOfKilometers;
        this.numberOfPassengers = numberOfPassengers;
        this.yearOfManufacture = yearOfManufacture;
        this.speed = speed;
    }

    // constructor nr.2
    public Car(String carBrand, String carType, int fuel, boolean passengerCapacity, int yearManufacture){
        this.carBrand = carBrand;
        this.carType = carType;

        // if the first letter of the brand's name does not match with any of the colors the color of the car is Black
        this.color = Color.valueOf("BLACK");

        // the color of the car: if the car's brand name starts with R the color should be red, G - Green, B - Blue, W - White, otherwise Black
        for(Color carColor:Color.values()){
            // the getChar() method return the first letter of the color constants
            if(carBrand.charAt(0) == carColor.getChar()){
                this.color = carColor;
                break;
            }
        }

        // if the fuel integer is greater than 2 the car is electric
        this.fuel = FuelType.valueOf("ELECTRIC");

        // based on the <fuel> int value a car can work with  0 - Diesel, 1 - Petrol, 2 - Gas, otherwise Electric
        for(FuelType nrFuel:FuelType.values()){
            // getNumber() method returns each fuels value
            if(fuel == nrFuel.getNumber()){
                this.fuel = nrFuel;
                break;
            }
        }

        if(passengerCapacity){ // if the passengerCapacity boolean is true it means we have a family car
            this.numberOfPassengers = 5;
        }
        else{ // else it is a two - seater car
            this.numberOfPassengers = 2;
        }

        this.yearOfManufacture = yearManufacture;

        // the speed and the numberOfKilometers variables automatically initializes with 0
    }

    // getter and setter methods for all attributes

    public String getCarBrand() {
        return carBrand;
    }
    public String getCarType() {
        return carType;
    }
    public Color getColor() { return color; }
    public FuelType getFuel() { return fuel; }
    public int getNumberOfKilometers() {
        return numberOfKilometers;
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public int getSpeed() {
        return speed;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public void setNumberOfKilometers(int numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
        resetMileage();
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // method which changes the speed of the car (accelerate and decelerate)
    public void changeSpeed(int speedIndicator){
        if(speed + speedIndicator > 0){
            speed += speedIndicator;
        }
        else{
            System.out.printf("Can not decelerate more than %d km/h!\n The car has stopped.", speed);
            speed = 0;
        }
    }

    // method which helps the car to move
    public void moveCar(int distance){
        if(distance > 0){
            numberOfKilometers += distance;
            // check if the number of kilometers is greater or not than 200 km
            resetMileage();
        }
    }

    // the mileage resets after each 200 kilometers to zero
    public void resetMileage(){
        if(numberOfKilometers >= 200){
            // after every 200 km the number of kilometers should reset to zero + the remaining kilometers
            numberOfKilometers = numberOfKilometers % 200;
        }
    }

    // toString() method to print the attributes of the car
    public String toString(){
        String sentence = "";
        sentence = "This car is a " + carBrand + " " + carType + (numberOfPassengers == 5 ? " family " : " two - seater ") +
                fuel + " car which was manufactured in " + yearOfManufacture +". It has " + color + " color and the " +
                "number of kilometers traveled is: " + numberOfKilometers + ".";
        return sentence;
    }
}
