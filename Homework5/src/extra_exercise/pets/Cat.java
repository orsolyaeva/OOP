package extra_exercise.pets;

import extra_exercise.MyDate;
import extra_exercise.utils.Enums;

import java.util.Random;

public class Cat extends Pet{
    private Enums.CatBreed catBreed;
    private boolean hasPedigree;

    public Cat(boolean hasPedigree, MyDate birthDate, String petName, double currentWeight) {
        super(birthDate, petName, currentWeight);
        this.hasPedigree = hasPedigree;
        this.catBreed = Enums.CatBreed.values()[new Random().nextInt(Enums.CatBreed.values().length)];
    }

    public Enums.CatBreed getCatBreed() {
        return catBreed;
    }

    public boolean isHasPedigree() {
        return hasPedigree;
    }

    @Override
    public String toString() {
        return this.catBreed + " cat, named " + this.getPetName() + " born in: " + this.getBirthDate() + "\n";
    }

    @Override
    public Enums.PetType getPatientType() {
        return Enums.PetType.Cat;
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
        return "Meow-meow";
    }
}
