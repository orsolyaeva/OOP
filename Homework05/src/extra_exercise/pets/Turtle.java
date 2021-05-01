package extra_exercise.pets;

import extra_exercise.MyDate;
import extra_exercise.pets.Pet;
import extra_exercise.utils.Enums;

import java.util.Random;

public class Turtle extends Pet {
    private int numHibernatingMonths;
    private Enums.TurtleClassification classification;


    public Turtle(int numHibernatingMonths, MyDate birthDate, String petName, double currentWeight) {
        super(birthDate, petName, currentWeight);
        this.numHibernatingMonths = numHibernatingMonths;
        this.taxonomy = Enums.Taxonomy.REPTILES;
        this.classification = Enums.TurtleClassification.values()[new Random().nextInt(Enums.TurtleClassification.values().length)];
    }

    public int getNumHibernatingMonths() {
        return numHibernatingMonths;
    }

    public Enums.TurtleClassification getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return this.classification + " turtle, named " + this.getPetName() + " born in: " + this.getBirthDate() + "\n";
    }

    @Override
    public Enums.PetType getPatientType() {
        return Enums.PetType.Turtle;
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
        return "You cannot hear the voice of this turtle";
    }
}
