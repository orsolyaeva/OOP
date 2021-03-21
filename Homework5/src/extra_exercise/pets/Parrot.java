package extra_exercise.pets;

import extra_exercise.MyDate;
import extra_exercise.utils.Enums;
import extra_exercise.utils.Util;

import java.util.ArrayList;
import java.util.Random;

public class Parrot extends Pet {
    private ArrayList<String> alreadyKnownWords = new ArrayList<>();
    private final boolean canSpeak;
    private final Enums.BodyType bodyType;

    public Parrot(boolean canSpeak, MyDate birthDate, String petName, double currentWeight) {
        super(birthDate, petName, currentWeight);
        this.taxonomy = Enums.Taxonomy.BIRDS;
        this.bodyType = Enums.BodyType.values()[new Random().nextInt(3)];
        this.canSpeak = canSpeak;
    }

    private void initializeKnownWords(){
        if(Util.commonWords.isEmpty()) {
            Util.readCommonWordsFromFile("Homework5/commonWords.txt");
        }

        int randomNumberOfKnownWords = Util.random.nextInt(Util.commonWords.size());

        for(int i = 0; i < randomNumberOfKnownWords; i++){
            int index = Util.random.nextInt(Util.commonWords.size());
            this.alreadyKnownWords.add(Util.commonWords.get(index));
        }
    }


    @Override
    public String toString() {
        return this.bodyType + " parrot, named " + this.getPetName() + " born in: " + this.getBirthDate() + "\n";
    }

    public boolean isCanSpeak() {
        return canSpeak;
    }

    public Enums.BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public Enums.PetType getPatientType() {
        return Enums.PetType.Parrot;
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
        initializeKnownWords();
        if(canSpeak && alreadyKnownWords.size() != 0){
            StringBuilder words = new StringBuilder();
            words.append("This parrot already knows the following words:\n");
            words.append("\t\t\t");
            int countWords = 0;
            for(String knownWords : alreadyKnownWords){
                words.append(knownWords).append(" ");
                countWords += 1;
                if(countWords % 20 == 0){
                    words.append("\n");
                }
            }

            return words.toString();
        }
        return null;
    }
}
