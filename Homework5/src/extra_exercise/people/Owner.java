package extra_exercise.people;

import extra_exercise.MyDate;
import extra_exercise.pets.Pet;
import extra_exercise.utils.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public class Owner extends Person{
    private final ArrayList<Pet> pets = new ArrayList<>();

    public Owner(MyDate dateOfBirth, Enums.Gender gender, String firstName, String lastName, String contact) {
        super(dateOfBirth, gender, firstName, lastName, contact);
    }

    public void addNewPets(Pet... pets){
        this.pets.addAll(Arrays.asList(pets));
    }

    public String getPet(String petName){
        if(this.pets.size() != 0){
            for(Pet pet:pets){
                if(pet.getPetName().equals(petName)){
                    return pet.toString();
                }
            }
        }
        return "The owner has no pet named " + petName;
    }

    public String noiseInOwnersHouse(){
        if(this.pets.size() != 0){
            StringBuilder noises = new StringBuilder();
            noises.append(this.fullName + "'s house is noisy. Listen..." + "\n");
            for(Pet pet:pets){
                noises.append("\t- " + pet.speak() + "\n");
            }

            return noises.toString();
        }
        return this.fullName + "'s house is quiet because she does not have any pets.";
    }

    @Override
    public String toString() {
       StringBuilder owner = new StringBuilder();
       owner.append(this.fullName + " is an owner\n");
       owner.append("\tContact information:\n");
       owner.append("\t\t- Personal ID: " + this.personId + "\n");
       owner.append("\t\t- Date of birth: " + this.dateOfBirth + "\n");
       if(this.gender.equals(Enums.Gender.MALE)){
           owner.append("\t\t- He ");
       }
       else{
           owner.append("\t\t- She ");
       }
       if(this.pets.size() == 0){
           owner.append("does not have any pets\n");
       }
       else{
           owner.append("has " + (this.pets.size() - 1) + " pets:\n");
           for(Pet pet: pets){
               owner.append("\t\t\t~ a " + pet.toString());
           }
       }

       return owner.toString();
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }
}
