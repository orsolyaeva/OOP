package extra_exercise;

import extra_exercise.interfaces.IDoctor;
import extra_exercise.interfaces.IPatient;
import extra_exercise.people.Owner;
import extra_exercise.people.Person;
import extra_exercise.people.Veterinarian;
import extra_exercise.pets.*;
import extra_exercise.utils.DateUtil;
import extra_exercise.utils.Enums;
import extra_exercise.utils.Util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private final static ArrayList<String> alma = new ArrayList<>();
    public static void main(String[] args){
        Owner owner1 = new Owner(new MyDate(1997, 7, 8), Enums.Gender.FEMALE,
                "Anne", "SMITH", "+40-741-234-567");

//        System.out.println(owner1);
//        System.out.println(owner1.noiseInOwnersHouse());

        int weight = Integer.parseInt(Util.getRandomNumber(20));
        Cat pet1 = new Cat(true, generateDate(), "Joe", weight);

        weight = Integer.parseInt(Util.getRandomNumber(30));
        Dog pet2 = new Dog(true, generateDate(), "Lizzie", weight);

        weight = Integer.parseInt(Util.getRandomNumber(30));
        int numberHibernatingMonths = Integer.parseInt(Util.getRandomNumber(13));
        Turtle pet3 = new Turtle(numberHibernatingMonths, generateDate(), "Tim", weight);

        weight = Integer.parseInt(Util.getRandomNumber(6));
        Parrot pet4 = new Parrot(true, generateDate(), "Mary", weight);

        owner1.addNewPets(pet1, pet2, pet3, pet4);
//        System.out.println(owner1);

//        System.out.println(owner1.noiseInOwnersHouse());

        Veterinary medicalCenter = new Veterinary(
                "str. Suceava Nr. 4 Targu Mures 540366 Romania",
                "0740 491 345",
                "AssisiVet");

        System.out.println(medicalCenter);

        Util.readDiseasesAndTreatments("Homework5/diseases.csv");

        Util.printAllDiseasesByPetType(Enums.PetType.Dog);
        Util.printAllDiseasesByPetType(Enums.PetType.Parrot);
        Util.printAllDiseasesByPetType(Enums.PetType.Cat);
        Util.printAllDiseasesByPetType(Enums.PetType.Turtle);

        owner1.getPet("Lizzie").unexpectedIllnessOccurred();
        owner1.getPet("Lizzie").checkHealthStatus();

        medicalCenter.assignPatientToADoctor(owner1.getPet("Lizzie"));

        medicalCenter.hireDoctor(new Veterinarian(generateDate(), Enums.Gender.MALE, "John", "Black", "0722 533 308"));
        medicalCenter.hireDoctor(new Veterinarian(generateDate(), Enums.Gender.FEMALE, "Mary", "White", "0748 342 123"));
        medicalCenter.hireDoctor(new Veterinarian(generateDate(), Enums.Gender.MALE, "Peter", "KALE", "0722 123 211"));

        System.out.println("\nNumber of possible appointments for Lizzie: " +
                medicalCenter.getNumberOfFreeAppointmentsByPatient(owner1.getPet("Lizzie")));


        IDoctor doc = medicalCenter.assignPatientToADoctor(owner1.getPet("Lizzie"));
        if(doc != null) {
            doc.treatPatient(owner1.getPet("Lizzie"));
        }
    }

    public static MyDate generateDate(){
        int year = Integer.parseInt(Util.getRandomNumber(2)) + 2018;
        int month = Integer.parseInt(Util.getRandomNumber(12)) + 1;
        int day = Integer.parseInt(Util.getRandomNumber(30)) + 1;
        if(!DateUtil.isValidDate(year, month, day)){
            generateDate();
        }
        return new MyDate(year, month, day);
    }
}
