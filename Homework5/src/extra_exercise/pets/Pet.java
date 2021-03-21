package extra_exercise.pets;

import extra_exercise.interfaces.IPatient;
import extra_exercise.MyDate;
import extra_exercise.utils.Enums;
import extra_exercise.utils.Util;

import java.util.ArrayList;

public abstract class Pet implements IPatient {
    public static int numPets = 0;
    protected ArrayList<String> diseases = new ArrayList<>();

    private int petId;
    protected Enums.Taxonomy taxonomy;
    private boolean healthy;
    private MyDate birthDate;
    private String petName;
    private double currentWeight;

    public Pet(MyDate birthDate, String petName, double currentWeight) {
        this.birthDate = birthDate;
        this.petName = petName;
        this.currentWeight = currentWeight;
        this.healthy = true;
        this.petId = numPets++;
    }

    public abstract String speak();

    public void unexpectedIllnessOccurred(){
        int randomIllness = Util.random.nextInt((Util.getNumOfDiseasesByPet(getPatientType()) - 1));
        this.diseases.add(Util.getDiseasesByPetType(getPatientType()).get(randomIllness).getDisease());
        this.healthy = false;
    }

    public void checkHealthStatus(){
        if(isHealthy()){
            System.out.println(this.petName + " is healthy.");
        }
        else{
            System.out.println(this.petName + " is suffering from the following diseases:\n");
            for(String disease: diseases){
                System.out.print("\t-" + disease);
            }
        }
    }

    public void healing(){
        this.healthy = true;
    }

    public static int getNumPets() {
        return numPets;
    }

    public int getPetId() {
        return petId;
    }

    public Enums.Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public String getPetName() {
        return petName;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "diseases=" + diseases +
                ", petId=" + petId +
                ", taxonomy=" + taxonomy +
                ", healthy=" + healthy +
                ", birthDate=" + birthDate +
                ", petName='" + petName + '\'' +
                ", currentWeight=" + currentWeight +
                '}';
    }

    @Override
    public String getDiseases()
    {
        return diseases.toString();
    }
}
