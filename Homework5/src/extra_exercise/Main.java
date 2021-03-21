package extra_exercise;

import extra_exercise.people.Owner;
import extra_exercise.people.Person;
import extra_exercise.pets.*;
import extra_exercise.utils.DateUtil;
import extra_exercise.utils.Enums;
import extra_exercise.utils.Util;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Owner owner1 = new Owner(new MyDate(1997, 7, 8), Enums.Gender.FEMALE,
                "Anne", "SMITH", "+40-741-234-567");

        System.out.println(owner1);
        System.out.println(owner1.noiseInOwnersHouse());

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
        System.out.println(owner1);

        System.out.println(owner1.noiseInOwnersHouse());
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
