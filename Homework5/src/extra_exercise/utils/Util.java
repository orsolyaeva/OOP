package extra_exercise.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Util {
    public static Random random = new Random();
    public static ArrayList<String> commonWords = new ArrayList<>();
    public static ArrayList<Disease> diseases = new ArrayList<>();

    public static void readDiseasesAndTreatments(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        }catch(FileNotFoundException e){
            System.out.println("An error occurred while reading the file!");
            System.exit(1);
        }

        StringTokenizer tokens;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            tokens = new StringTokenizer(line, ",");
            Disease temp = new Disease(Enums.PetType.valueOf(tokens.nextToken()), tokens.nextToken());
            List<String> treats = new ArrayList<>();
            while(tokens.hasMoreTokens()){
                treats.add(tokens.nextToken());
            }
            temp.addTreatments(treats);
            diseases.add(temp);
        }
    }

    public static void printAllDiseasesByPetType(Enums.PetType petType){
        for (Disease disease : diseases){
            if(disease.getPetType().equals(petType)){
                System.out.println(disease.getDisease());
            }
        }
    }

    public static ArrayList<Disease> getDiseasesByPetType(Enums.PetType petType){
        ArrayList<Disease> diseasesByPetType = new ArrayList<>();
        for(Disease disease : diseases){
            if(disease.getPetType().equals(petType)){
                diseasesByPetType.add(new Disease(petType, disease.getDisease()));
            }
        }

        return diseasesByPetType;
    }

    public static int getNumOfDiseasesByPet(Enums.PetType petType){
        int count = 0;
        for(Disease disease:diseases){
            if(disease.getPetType().equals(petType)){
                if(disease.getDisease() != null){
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void readCommonWordsFromFile(String fileName){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(fileName));
        }catch(FileNotFoundException e){
            System.out.println("An error occurred while reading the file!");
            System.exit(1);
        }

        StringTokenizer tokens;
        while(scanner.hasNextLine()){
            commonWords.add(scanner.nextLine());
        }
    }

    public static String getRandomNumber(int number){
        StringBuilder randomNumber = new StringBuilder();
        randomNumber.append(random.nextInt(number) + 1);
        return randomNumber.toString();
    }

    public static String treatmentsByDiseaseType(String diseaseType){
        StringBuilder treatments = new StringBuilder();
        for(Disease disease:diseases){
            if(disease.getDisease().equals(diseaseType)){
                treatments.append(disease.treatments);
            }
        }
        return treatments.toString();
    }

    public static class Disease{
       private final  ArrayList<String> treatments = new ArrayList<>();
       private final Enums.PetType petType;
       private final String disease;

        public Disease(Enums.PetType petType, String disease) {
            this.petType = petType;
            this.disease = disease;
        }

        public void addTreatments(List<String> treatment){
            this.treatments.addAll(treatment);
        }

        public Enums.PetType getPetType() {
            return petType;
        }

        public String getDisease() {
            return disease;
        }

        @Override
        public String toString() {
            return "Disease{" +
                    "treatments=" + treatments +
                    ", petType=" + petType +
                    ", disease='" + disease + '\'' +
                    '}';
        }
    }
}

