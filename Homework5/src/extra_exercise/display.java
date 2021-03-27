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

import java.util.*;

public class display {
    public static Scanner read = new Scanner(System.in);
    public static Random rand = new Random();
    private static final ArrayList<Veterinary> veterinaries = new ArrayList<>();
    private static final ArrayList<Pet> pets = new ArrayList<>();
    private static final ArrayList<Veterinarian> doctors = new ArrayList<>();

    public static void selectUserType(){
        initialize();
        initializePatients();

        while(true){
            System.out.println("\nHOME");
            System.out.println("1. Owner");
            System.out.println("2. Veterinarian");
            System.out.println("3. Veterinary");
            System.out.println("4. Exit");

            System.out.print("Select User type: ");
            int user = read.nextInt();
            switch (user) {
                case 1 -> ownerInterface();
                case 2 -> veterinarianInterface();
                case 3 -> veterinaryInterface();
                case 4 -> System.exit(0);
                default -> System.out.println("Try Again!");
            }
        }
    }

    public static void ownerInterface(){
        Owner myAccount = ownerSignUp();
        System.out.println("\nYou successfully signed up as an owner named " + myAccount.getFullName() + "!\n");

        ownerActions(myAccount);
    }

    public static void veterinarianInterface(){
        Veterinarian myAccount = veterinarianSignUp();
        doctors.add(myAccount);
        System.out.println("\nYou successfully signed up as a veterinarian named " + myAccount.getFullName() + "!\n");

        veterinarianActions(myAccount);
    }

    public static void veterinaryInterface(){
        Veterinary myAccount = veterinarySignUp();
        veterinaries.add(myAccount);

        System.out.println("\nYou successfully signed up as a Veterinary named " + myAccount.getName() + "!\n");

        veterinaryActions(myAccount);
    }

    public static Veterinarian veterinarianSignUp(){
        System.out.println("\nSign up as a Veterinarian:");

        System.out.print("\tDate of birth (yyyy-mm-dd): ");
        read.nextLine();
        String date = read.nextLine();
        boolean checkDate = false;
        int year = -1, month = -1, day = -1;

        while(!checkDate){
            if(date.length() < 10 || date.charAt(4) != '-' || date.charAt(7) != '-'){
                System.out.println("\t\tERROR! The date of birth field must be entered in YYYY-MM-DD format!");
                System.out.print("\tDate of birth (yyyy-mm-dd):");
                date = read.nextLine();
            }
            else{
                checkDate = true;

                StringTokenizer token = new StringTokenizer(date, "-");
                year = Integer.parseInt(token.nextToken());
                month = Integer.parseInt(token.nextToken());
                day = Integer.parseInt(token.nextToken());

                if(!DateUtil.isValidDate(year, month, day)){
                    System.out.println("\t\tERROR! Please enter a valid date!");
                    checkDate = false;

                    System.out.print("\tDate of birth (yyyy-mm-dd):");
                    date = read.nextLine();
                }
            }
        }

        Enums.Gender gender;
        do {
            gender = getGender(null);

        } while (gender == null);

        System.out.print("\tFirst name:");
        read.nextLine();
        String firstName = read.nextLine();

        System.out.print("\tLast name:");
        String lastName = read.nextLine();

        System.out.print("\tContact (ex. phone number): ");
        String contact = read.nextLine();

        return new Veterinarian(new MyDate(year, month, day), gender, firstName, lastName, contact);
    }

    public static Owner ownerSignUp(){
        System.out.println("\nSign up as an Owner:");

        System.out.print("\tDate of birth (yyyy-mm-dd): ");
        read.nextLine();
        String date = read.nextLine();
        boolean checkDate = false;
        int year = -1, month = -1, day = -1;

        while(!checkDate){
            if(date.length() < 10 || date.charAt(4) != '-' || date.charAt(7) != '-'){
                System.out.println("\t\tERROR! The date of birth field must be entered in YYYY-MM-DD format!");
                System.out.print("\tDate of birth (yyyy-mm-dd):");
                date = read.nextLine();
            }
            else{
                checkDate = true;

                StringTokenizer token = new StringTokenizer(date, "-");
                year = Integer.parseInt(token.nextToken());
                month = Integer.parseInt(token.nextToken());
                day = Integer.parseInt(token.nextToken());

                if(!DateUtil.isValidDate(year, month, day)){
                    System.out.println("\t\tERROR! Please enter a valid date!");
                    checkDate = false;

                    System.out.print("\tDate of birth (yyyy-mm-dd):");
                    date = read.nextLine();
                }
            }
        }

        Enums.Gender gender;
        do {
            gender = getGender(null);

        } while (gender == null);

        System.out.print("\tFirst name:");
        read.nextLine();
        String firstName = read.nextLine();

        System.out.print("\tLast name:");
        String lastName = read.nextLine();

        System.out.print("\tContact (ex. phone number): ");
        String contact = read.nextLine();

        return new Owner(new MyDate(year, month, day), gender, firstName, lastName, contact);
    }

    private static Enums.Gender getGender(Enums.Gender gender) {
        System.out.println("\tGender:\t1 - Female   2 - Male");
        System.out.print("\tEnter your gender: ");
        int yourGender = read.nextInt();

        switch (yourGender) {
            case 1 -> gender = Enums.Gender.FEMALE;
            case 2 -> gender = Enums.Gender.MALE;
            default -> System.out.println("Try Again!");
        }
        return gender;
    }

    public static void buyNewAnimals(Owner owner){
        System.out.println("\nHurray! Let's get you some new Friends!");

        System.out.println("\t1 - Cat\n\t2 - Dog\n\t3 - Turtle\n\t4 - Parrot\n\t5 - Finished shopping");
        while(true){
            System.out.print("\nEnter the number of the pet you would like to buy here: ");
            int pet = read.nextInt();

            switch (pet){
                case 1: { // get a cat
                    MyDate date = generateDate();
                    int weight = rand.nextInt(10);
                    boolean hasPedigree = rand.nextBoolean();

                    System.out.print("\tEnter the name of your new cat: ");
                    read.nextLine();
                    String catName = read.nextLine();

                    owner.addNewPets(new Cat(hasPedigree, date, catName, weight));
                    pets.add(owner.getPet(catName));
                    System.out.println("Congratulations! You are now the successful owner of " + catName + " the cat!");
                    break;
                }
                case 2:{ // get a dog
                    MyDate date = generateDate();
                    int weight = rand.nextInt(20);
                    boolean goodHouseKeeper = rand.nextBoolean();

                    System.out.print("\tEnter the name of your new dog: ");
                    read.nextLine();
                    String dogName = read.nextLine();

                    owner.addNewPets(new Dog(goodHouseKeeper, date, dogName, weight));
                    pets.add(owner.getPet(dogName));
                    System.out.println("Congratulations! You are now the successful owner of " + dogName + " the dog!");
                    break;
                }
                case 3:{ // get a turtle
                    MyDate date = generateDate();
                    int weight = rand.nextInt(10);
                    int hibernatingMonths = rand.nextInt(12);

                    System.out.print("\tEnter the name of your new turtle: ");
                    read.nextLine();
                    String turtleName = read.nextLine();

                    owner.addNewPets(new Turtle(hibernatingMonths, date, turtleName, weight));
                    pets.add(owner.getPet(turtleName));
                    System.out.println("Congratulations! You are now the successful owner of " + turtleName + " the turtle!");
                    break;
                }
                case 4: { // get a parrot
                    MyDate date = generateDate();
                    int weight = rand.nextInt(5);
                    boolean canSpeak = rand.nextBoolean();

                    System.out.print("\tEnter the name of your new parrot: ");
                    read.nextLine();
                    String parrotName = read.nextLine();

                    owner.addNewPets(new Parrot(canSpeak, date, parrotName, weight));
                    pets.add(owner.getPet(parrotName));
                    System.out.println("Congratulations! You are now the successful owner of " + parrotName + " the parrot!");
                    break;
                }
                case 5: {
                    System.out.println("\nThank you for shopping at out store!" +
                            " Please take care of your new friends and if you have any questions feel " +
                            "free to contact us!\n");
                    break;
                }
                default:{
                    System.out.println("\tUnfortunately we don't have this kind of pet right now! :(");
                    break;
                }
            }

            if(pet == 5){
                ownerActions(owner);
            }
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

    public static void getFreeAppointments(Owner owner){
        System.out.print("Enter the name of your sick pet: ");
        read.nextLine();
        String name = read.nextLine();

        System.out.println("Loading data about your pet...");
        owner.getPet(name).unexpectedIllnessOccurred();
        owner.getPet(name).checkHealthStatus();

        int nrPossibleAppointments = 0;
        for(Veterinary veterinary:veterinaries){
            nrPossibleAppointments += veterinary.getNumberOfFreeAppointmentsByPatient(owner.getPet(name));
        }

        System.out.println("\nNumber of possible appointments for " + name + " is: " + nrPossibleAppointments);

        if(nrPossibleAppointments != 0){
            chooseVeterinary(owner, owner.getPet(name));
        }
        else{
            ownerActions(owner);
        }
    }

    public static void chooseVeterinary(Owner owner, Pet sickPet){
        System.out.println("\n\t\tTIME TO HEAL YOUR PET!\n");
        System.out.print("Enter the name of the veterinary you choose: ");
        String veterinaryName = read.nextLine();

        for(Veterinary veterinary:veterinaries){
            if(veterinary.getName().equals(veterinaryName)){
                veterinary.getNumberOfFreeAppointmentsByPatient(sickPet);
                chooseDoctor(owner, veterinary, sickPet);
            }
        }
    }

    public static void chooseDoctor(Owner owner, Veterinary veterinary, Pet sickPet){
        System.out.print("Enter the name of the doctor you chose to heal your pet:");
        String doctorName = read.nextLine();

        for(IDoctor doctor:veterinary.getDoctorsByPatientType(sickPet.getPatientType())){
            if(doctor instanceof Veterinarian){
               if(((Veterinarian) doctor).getFullName().equals(doctorName)){
                   doctor.addNewPatient(sickPet);
                   doctor.treatPatient(sickPet);
               }
            }
        }

        ownerActions(owner);

    }

    public static void initialize(){
        Util.readDiseasesAndTreatments("Homework5/diseases.csv");

        Veterinary medicalCenter = new Veterinary(
                "str. Suceava Nr. 4 Targu Mures 540366 Romania",
                "0740 491 345",
                "AssisiVet");

        veterinaries.add(medicalCenter);

        Veterinarian doctor;

        doctor = new Veterinarian(generateDate(), Enums.Gender.MALE, "John", "Black", "0722 533 308");
        medicalCenter.hireDoctor(doctor);
        doctors.add(doctor);

        doctor = new Veterinarian(generateDate(), Enums.Gender.FEMALE, "Mary", "White", "0748 342 123");
        medicalCenter.hireDoctor(doctor);
        doctors.add(doctor);

        doctor = new Veterinarian(generateDate(), Enums.Gender.MALE, "Peter", "KALE", "0722 123 211");
        medicalCenter.hireDoctor(doctor);
        doctors.add(doctor);

        Veterinary medicalCenter2 = new Veterinary("Sos. Pandurii Nr. 31 Bucuresti 050654 Romania",
                "0732 1234 1232", "Regatul Animalelor");

        veterinaries.add(medicalCenter2);

        doctor = new Veterinarian(generateDate(), Enums.Gender.MALE, "Joshua", "Freeman", "0897 123 123");
        medicalCenter2.hireDoctor(doctor);
        doctors.add(doctor);

        doctor = new Veterinarian(generateDate(), Enums.Gender.FEMALE, "Frannie", "Goldsmith", "0127 222 123");
        medicalCenter2.hireDoctor(doctor);
        doctors.add(doctor);
    }

    public static void possibleDiseasesOfPet(Owner owner){
        System.out.print("\nEnter in which of your pets possible diseases are you interested in:");
        read.nextLine();
        String petName = read.nextLine();

        Util.printAllDiseasesByPetType((owner.getPet(petName).getPatientType()));

        ownerActions(owner);
    }

    public static void ownerActions(Owner owner){
        System.out.println("\nActions:\n\t1. Buy new pets\n\t2. Get free appointments\n\t3. My profile" +
                "\n\t4. Possible diseases of a pet\n\t5. Back to Home");
        System.out.print("Select one from the above actions: ");
        int action = read.nextInt();

        switch (action) {
            case 1 -> buyNewAnimals(owner);
            case 2 -> getFreeAppointments(owner);
            case 3 -> {
                System.out.println(owner);
                ownerActions(owner);
            }
            case 4 -> possibleDiseasesOfPet(owner);
            case 5 -> {
                System.out.println("\nYou successfully logged out from your account!");
                selectUserType();
            }
            default -> System.out.println("Something went wrong...Please try again!");
        }

    }

    public static void initializePatients(){
        pets.add(new Cat(true, generateDate(), "Joe", rand.nextInt(10)));
        pets.add(new Cat(true, generateDate(), "Pablo", rand.nextInt(10)));
        pets.add(new Cat(false, generateDate(), "Wanda", rand.nextInt(10)));
        pets.add(new Parrot(true, generateDate(), "Peter", rand.nextInt(10)));
        pets.add(new Parrot(true, generateDate(), "Paul", rand.nextInt(10)));
        pets.add(new Parrot(true, generateDate(), "Stu", rand.nextInt(10)));
        pets.add(new Cat(true, generateDate(), "Petty", rand.nextInt(10)));
        pets.add(new Dog(false, generateDate(), "Rambo", rand.nextInt(10)));
        pets.add(new Dog(false, generateDate(), "Stevie", rand.nextInt(10)));
        pets.add(new Dog(false, generateDate(), "Nex", rand.nextInt(10)));
        pets.add(new Dog(true, generateDate(), "Hugo", rand.nextInt(10)));
        pets.add(new Turtle(rand.nextInt(12) + 1, generateDate(), "Nick", rand.nextInt(10)));
        pets.add(new Turtle(rand.nextInt(12) + 1, generateDate(), "Panny", rand.nextInt(10)));
        pets.add(new Turtle(rand.nextInt(12) + 1, generateDate(), "Ervin", rand.nextInt(10)));
        pets.add(new Turtle(rand.nextInt(12) + 1, generateDate(), "Fanny", rand.nextInt(10)));
    }

    public static void acceptPatients(Veterinarian veterinarian){
        for(Pet pet:pets){
            pet.unexpectedIllnessOccurred();
            if(!pet.isHealthy() && veterinarian.getSpeciality().equals(pet.getPatientType())){
                veterinarian.addNewPatient(pet);
            }
        }
    }

    public static ArrayList<IPatient> prioritizePatients(Veterinarian veterinarian){
        ArrayList<IPatient> prioritizePatients = veterinarian.getPatient();

        prioritizePatients.removeIf(Objects::isNull);

        Collections.sort(prioritizePatients, Comparator.comparing(IPatient::getSeriosityOfCase));

        return prioritizePatients;
    }

    public static void treatPatient(Veterinarian veterinarian){
        ArrayList<IPatient> prioritizedPatients = prioritizePatients(veterinarian);

        veterinarian.treatPatient(prioritizedPatients.get(0));
    }

    public static void listMedicalCenters(Veterinarian veterinarian){
        for(Veterinary veterinary:veterinaries){
            System.out.println(veterinary.getMedCenterInformation());
        }

        System.out.print("\nWould you like to apply for a job? Enter your answer here (yes/no): ");
        String answer = read.next();
        if(answer.equals("yes")){
            applyToJob(veterinarian);
        }
        else{
            veterinarianActions(veterinarian);
        }
    }

    public static void applyToJob(Veterinarian veterinarian){
        System.out.print("\nEnter the name of the medical center you want to work in: ");
        read.nextLine();
        String medicalCenter = read.nextLine();

        for(Veterinary veterinary:veterinaries){
            if(veterinary.getName().equals(medicalCenter)){
                System.out.println("\n\tDear " + veterinarian.getFullName() + "!\nI'd like to inform you that we received your " +
                        "e-mail. We will keep you posted on the status of your application!\n" +
                        "Thank you, again, for taking the time to apply to this role at " + medicalCenter + ".");
                veterinary.hireDoctor(veterinarian);
            }
        }
        System.out.println("\n\tafter a few days...");
        System.out.println("\nCongratulations! This letter is to formally offer you the job you assigned for! " +
                "Your experience and credentials in the field will be an asset to our team!");
    }

    public static void veterinarianActions(Veterinarian veterinarian){
        while(true){
            System.out.println("\nActions:\n\t1. Accept patients\n\t2. Treat patients\n\t3. Prioritize patients" +
                    "\n\t4. List medical centers + apply for job\n\t5. My profile\n\t6. Back to Home");

            System.out.print("Select one from the above actions: ");
            int action = read.nextInt();
            switch (action) {
                case 1 -> acceptPatients(veterinarian);
                case 2 -> treatPatient(veterinarian);
                case 3 -> {
                    ArrayList<IPatient> patients = prioritizePatients(veterinarian);
                    System.out.println("\nYour patients:");
                    for (IPatient patient : patients) {
                        System.out.print("\t" + patient.toString());
                    }
                }
                case 4 -> listMedicalCenters(veterinarian);
                case 5 -> System.out.println(veterinarian.toString());

                case 6 -> {
                    System.out.println("\nYou successfully logged out from your account!");
                    selectUserType();
                }
                default -> System.out.println("Something went wrong...Please try again!");
            }
        }
    }

    public static Veterinary veterinarySignUp(){
        System.out.print("\nSign up as a Veterinary:");

        System.out.print("\n\tAddress: ");
        read.nextLine();
        String address = read.nextLine();

        System.out.print("\tName: ");
        String name = read.nextLine();

        System.out.print("\tContact: ");
        String contact = read.nextLine();

        return new Veterinary(address, contact, name);
    }

    public static void acceptPatients(Veterinary veterinary){
        if(veterinary.getDoctorsByPatientType(Enums.PetType.Dog).size() == 0 &&
                veterinary.getDoctorsByPatientType(Enums.PetType.Cat).size() == 0 &&
                veterinary.getDoctorsByPatientType(Enums.PetType.Turtle).size() == 0 &&
                veterinary.getDoctorsByPatientType(Enums.PetType.Parrot).size() == 0){
            System.out.println("\nWe are sorry but we have no doctors yet to treat your pets!");
            return;
        }
        for(Pet pet:pets){
            pet.unexpectedIllnessOccurred();
            if(veterinary.getDoctorsByPatientType(pet.getPatientType()).size() != 0){
                if(!pet.isHealthy()){
                    veterinary.assignPatientToADoctor(pet);
                }
            }
        }
    }

    public static void hireDoctors(Veterinary veterinary){
        for(IDoctor doctor:doctors){
            System.out.println(doctor.toString());
        }

        System.out.print("\nEnter the name of the doctor you want to hire: ");
        read.nextLine();
        String doctorName = read.nextLine();
        boolean found = false;

        System.out.println("Sending e-mail...");
        System.out.println("Waiting for answer...");
        for(IDoctor doctor:doctors){
            if(doctor instanceof Person){
                if(((Person) doctor).getFullName().equals(doctorName)){
                    found = true;
                    veterinary.hireDoctor(doctor);
                    System.out.println("\nWe successfully hired Dr. " + doctorName + "!");
                    break;
                }
            }
        }

        if(!found){
            System.out.println("No doctor named " + doctorName + " was found!");
        }
    }

    public static void fireDoctors(Veterinary veterinary){
        ArrayList<IDoctor> doctorArrayList = veterinary.getDoctors();

        for(IDoctor doctor:doctorArrayList){
            System.out.println(doctor.toString());
        }

        System.out.print("\nEnter the name of doctor you want to fire: ");
        read.nextLine();
        String doctorName = read.nextLine();
        boolean found = false;

        for(IDoctor doctor:doctorArrayList){
            if(doctor instanceof Person){
                if(((Person) doctor).getFullName().equals(doctorName)){
                    veterinary.fireDoctor(doctor);
                    found = true;
                    System.out.println("\nDr. " + doctorName + " was successfully fired!");
                    break;
                }
            }
        }

        if(!found){
            System.out.println("\nNo doctor named " + doctorName + " was found!");
        }
    }

    public static void listPatients(Veterinary veterinary){
        ArrayList<IDoctor> doctors1 = veterinary.getDoctors();

        if(veterinary.getDoctors().size() == 0){
            System.out.println("We have no patients yet!");
            return;
        }

        for(IDoctor doctor:doctors1){
            if(doctor instanceof Veterinarian){
                for(IPatient patient : ((Veterinarian) doctor).getPatient()){
                    System.out.println("\t" + patient.toString());
                }
            }
        }
    }

    public static void listDoctors(Veterinary veterinary){
        ArrayList<IDoctor> doctors1 = veterinary.getDoctors();

        if(veterinary.getDoctors().size() == 0){
            System.out.println("We have no doctors yet!");
            return;
        }

        for(IDoctor doctor:doctors1){
            System.out.println("\t" + doctor.toString());
        }
    }

    public static void veterinaryActions(Veterinary veterinary){
        while(true){
            System.out.println("\nActions:\n\t1. Accept patience\n\t2. Hire doctors\n\t3. Fire doctors" +
                    "\n\t4. List patients\n\t5. List doctors\n\t6. My profile\n\t7. Back to Home");
            System.out.print("Select one from the above actions: ");
            int action = read.nextInt();

            switch (action){
                case 1: acceptPatients(veterinary); break;
                case 2: hireDoctors(veterinary); break;
                case 3: fireDoctors(veterinary); break;
                case 4:{
                    System.out.println("\nPatients: ");
                    listPatients(veterinary);
                    break;
                }
                case 5:{
                    System.out.println("\nDoctors:");
                    listDoctors(veterinary);
                    break;
                }
                case 6:{
                    System.out.println("\n" + veterinary);
                    break;
                }
                case 7:{
                    selectUserType();
                }
                default:{
                    System.out.println("Something went wrong...Please try again!");
                    break;
                }
            }
        }
    }
}
