package extra_exercise.utils;

import java.util.PropertyPermission;

public class Enums {
    public enum Seriosity{
        GREEN, YELLOW, RED
    }

    public enum BodyType{
        Small, Medium, Large
    }

    public enum PetType{
        Dog, Cat, Turtle, Parrot
    }

    public enum Taxonomy{
        MAMMALS, BIRDS, REPTILES, FISH, AMPHIBIANS, INVERTEBRATES
    }

    public enum Gender{
        FEMALE, MALE
    }

    public enum TurtleClassification{
        Testudinoidea, Emydidae, Testudinidae, Geoemydidae, Trionychidae
    }

    public enum CatBreed{
        Polydactyl("Polydactyl"), Snowshoe("Snowshoe"), Calico("Calico"),
        BritishShortHair("British Shorthaired"), Siamese("Siamese"),
        JapaneseBobtail("Japanese Bobtail"), Persian("Persian"), ScottishFold("Japanese Bobtail"),
        GrayTabby("Gray tabby");

        private String value;

        public String getValue() {
            return value;
        }

        private CatBreed(String value){
            this.value = value;
        }

        private CatBreed(){
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum DogBreed{
        LabradorRetrievers("Labrador Retrievers"), GermanShepherds("German Shepherds"),
        GoldenRetrievers("Golden Retrievers"), FrenchBulldogs("French Bulldogs"),
        Bulldogs("Bulldogs"), Beagles("Beagles"), Poodles("Poodles");

        private String value;

        public String getValue() {
            return value;
        }

        private DogBreed(String value) {
            this.value = value;
        }

        private DogBreed(){
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
