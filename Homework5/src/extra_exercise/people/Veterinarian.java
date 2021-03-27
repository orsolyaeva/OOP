package extra_exercise.people;

import extra_exercise.MyDate;
import extra_exercise.interfaces.IDoctor;
import extra_exercise.interfaces.IPatient;
import extra_exercise.pets.Pet;
import extra_exercise.utils.Enums;
import extra_exercise.utils.Util;

import java.util.ArrayList;
import java.util.Random;

public class Veterinarian extends Person implements IDoctor {
    public static final int MAX_PATIENTS_PER_DAY = new Random().nextInt(20) + 3;
    private final ArrayList<IPatient> patients = new ArrayList<>();
    private Enums.PetType speciality;
    private final String fullName;

    public Veterinarian(MyDate dateOfBirth, Enums.Gender gender, String firstName, String lastName, String contact) {
        super(dateOfBirth, gender, firstName, lastName, contact);
        this.fullName = firstName + " " + lastName;
        this.speciality = Enums.PetType.values()[new Random().nextInt(Enums.PetType.values().length)];
    }

    public Enums.PetType getSpeciality() {
        return speciality;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void addNewPatient(IPatient patient) {
        if(patient.getPatientType().equals(this.speciality)){
            if(isAvailable()){
                this.patients.add(patient);
                if(patient instanceof Pet){
                    System.out.println(((Pet) patient).getPetName() + " successfully assigned to " + this.fullName + ".");
                }
            }
            else{
                System.out.println("Can not work with more patients today!\n");
            }
        }
    }

    @Override
    public boolean treatPatient(IPatient patient) {
        System.out.println("\nDr. " + this.fullName + " started to heal your pet...");
        System.out.println("Generating required treatment...");

        if(patient instanceof Pet){
            ((Pet) patient).healing();
            System.out.println(patient.getDiseases());
            System.out.println("\n" + ((Pet) patient).getPetName() + " should recover soon. Take care.");
            this.patients.set(this.patients.indexOf(patient), null);
            System.out.println("Pet removed from patient list.");
            return true;
        }
        return false;
    }

    public ArrayList<IPatient> getPatient(){
        ArrayList<IPatient> patients1 = this.patients;
        return patients1;
    }

    @Override
    public boolean isAvailable() {
        return this.patients.size() < MAX_PATIENTS_PER_DAY;
    }

    @Override
    public int getNumberCurrentPatients() {
        return this.patients.size();
    }

    @Override
    public String toString() {
        StringBuilder veterinarian = new StringBuilder();
        veterinarian.append("\nDr. " + this.fullName + " is a " + this.speciality + " specialist veterinarian");
        veterinarian.append("\n\tContact information: ");
        veterinarian.append("\n\t\t- Tel. number: " + this.contact);
        veterinarian.append("\n\t\t- Personal ID: " + this.personId);
        veterinarian.append("\n\t\t- Date of birth: " + this.dateOfBirth);

        if(this.gender.equals(Enums.Gender.MALE)){
            veterinarian.append("\n\t\t- He");
        }
        else{
            veterinarian.append("\n\t\t- She");
        }

        if(this.getNumberCurrentPatients() == 0){
            veterinarian.append(" does not have any patients.");
        }
        else{
            veterinarian.append(" has " + this.getNumberCurrentPatients() + " patients\n");
        }

        return veterinarian.toString();
    }
}
