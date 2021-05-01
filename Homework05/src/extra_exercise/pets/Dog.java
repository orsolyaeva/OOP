package extra_exercise.pets;

import extra_exercise.MyDate;
import extra_exercise.utils.Enums;

import java.util.Random;

public class Dog extends Pet {
    private Enums.DogBreed dogBreed;
    private boolean goodHouseKeeper;

    public Dog(boolean goodHouseKeeper, MyDate birthDate, String petName, double currentWeight) {
        super(birthDate, petName, currentWeight);
        this.taxonomy = Enums.Taxonomy.MAMMALS;
        this.goodHouseKeeper = (new Random().nextBoolean());
        this.dogBreed = Enums.DogBreed.values()[new Random().nextInt(Enums.DogBreed.values().length)];
    }

    public Enums.DogBreed getDogBreed() {
        return dogBreed;
    }

    public boolean isGoodHouseKeeper() {
        return goodHouseKeeper;
    }

    @Override
    public String toString() {
        return this.dogBreed + " dog, named " + this.getPetName() + " born in: " + this.getBirthDate() + "\n";
    }

    @Override
    public Enums.PetType getPatientType() {
        return Enums.PetType.Dog;
    }

    @Override
    public Enums.Seriosity getSeriosityOfCase() {
        if(isHealthy()){
            return Enums.Seriosity.GREEN;
        }
        else{
            return Enums.Seriosity.values()[new Random().nextInt(2) + 1];
        }
    }

    @Override
    public String speak() {
        return "Woof-woof";
    }
}
