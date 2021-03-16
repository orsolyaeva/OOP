package extra_exercise.utils;

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
        Polydactyl, Snowshoe, Calico, BritishShortHair, Siamese, JapaneseBobtail, Persian, ScottishFold, GrayTabby;

        private String value;

        private CatBreed(String value){
            this.value = value;
        }

        private CatBreed(){
        }

        @Override
        public String toString() {
            return "CatBreed{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public enum DogBreed{
        LabradorRetrievers, GermanShepherds, GoldenRetrievers, FrenchBulldogs, Bulldogs, Beagles, Poodles;

        private String value;

        private DogBreed(String value) {
            this.value = value;
        }

        private DogBreed(){
        }

        @Override
        public String toString() {
            return "DogBreed{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
