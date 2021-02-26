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

    public Car(String carType, String carBrand, Color color, FuelType fuel,  int numberOfKilometers, int numberOfPassengers, int yearOfManufacture, int speed){
        this.carType = carType;
        this.carBrand = carBrand;
        this.color = color;
        this.fuel = fuel;
        this.numberOfKilometers = numberOfKilometers;
        this.numberOfPassengers = numberOfPassengers;
        this.yearOfManufacture = yearOfManufacture;
        this.speed = speed;
    }

    public Car(String carBrand, String carType, int fuel, boolean passengerCapacity, int yearManufacture){
        this.carBrand = carBrand;
        this.carType = carType;

        for(Color carColor:Color.values()){
            if(carType.charAt(0) == carColor.getChar()){
                this.color = carColor;
            }
        }
        if(this.color == null){
            this.color = Color.valueOf("BLACK");
        }

        for(FuelType nrFuel:FuelType.values()){
            if(fuel == nrFuel.getNumber()){
                this.fuel = nrFuel;
            }
        }
        if(this.fuel == null){
            this.fuel = FuelType.valueOf("ELECTRIC");
        }

        if(passengerCapacity){
            this.numberOfPassengers = 5;
        }
        else{
            this.numberOfPassengers = 2;
        }

        this.yearOfManufacture = yearManufacture;
//        this.speed = 0;
//        this.numberOfKilometers = 0;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarType() {
        return carType;
    }

    public Color getColor() {
        return color;
    }

    public FuelType getFuel() {
        return fuel;
    }

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

    public void changeSpeed(int speedIndicator){
        if(speed + speedIndicator > 0){
            speed += speedIndicator;
        }
        else{
            System.out.printf("Can not decelerate more than %d\n! The car stopped.", speed);
            speed = 0;
            return;
        }
    }

    public void moveCar(int distance){
        if(distance > 0){
            numberOfKilometers += distance;
            resetMileage();
        }
    }

    public void resetMileage(){
        if(numberOfKilometers >= 200){
            numberOfKilometers = numberOfKilometers % 200;
        }
    }

    public String toString(){
        String sentence = "";
        sentence = "This car is a " + carBrand + " " + carType;
        if(numberOfPassengers == 5){
            sentence += " family ";
        }
        else{
            sentence += " two - seater";
        }
        sentence += " " + fuel + " car which was manufactured in " + yearOfManufacture +". It has " + color + " color and the " +
                "number of kilometers traveled is: " + numberOfKilometers + ".";
        return sentence;
    }
}
