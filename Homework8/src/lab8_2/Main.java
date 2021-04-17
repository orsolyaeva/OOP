package lab8_2;

/**
 * Hash set is faster than TreeSet and should be the preferred choice if sorting elements is NOT required.
 * For operations like search, insert and delete it takes constant time for these operations on average.
 * Elements in HashSet are not ordered.
 *
 * TreeSet takes O(Log n) for search, insert and delete which is higher than HashSe, but TreeSet keeps sorted data.
 * TreeSet elements are sorted in ascending order by default.
 *
 * In case of a dictionary I prefer TreeSets over HashSets because we require SORTED and UNIQUE elements, instead of
 * unique elements.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        DictionaryService service = null;
        while(true){
            System.out.print("\n1. Array list\n2. Tree set\n3. Hash set\n4. Exit\nEnter what kind of data structure you want to use: ");
            int dictionaryType = read.nextInt();
            switch (dictionaryType) {
                case 1 -> {
                    service = new DictionaryService(DictionaryType.ARRAY_LIST);
                }
                case 2 -> {
                    service = new DictionaryService(DictionaryType.TREE_SET);
                }
                case 3 -> {
                    service = new DictionaryService(DictionaryType.HASH_SET);
                }
                case 4 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("The given data structure does not exist! Try again!");
                    System.exit(1);
                }
            }

            boolean end = false;
            while (true) {
                System.out.print("\n1. Search for a word\n2. Search for all the words of a text file\n3. Choose another data structure" +
                        "\n4. Exit\nEnter what you want to do:");
                int exercise = read.nextInt();

                switch (exercise) {
                    case 1 -> {
                        Scanner scanner = new Scanner(System.in);
                        while (true) {
                            System.out.print("Word to find ( Enter <end> for exit): ");
                            String word = scanner.nextLine();
                            if (word.equalsIgnoreCase("end")) {
                                break;
                            }
                            System.out.println(" Find(" + word + "): " + service.findWord(word));
                        }
                    }
                    case 2 -> {
                        ArrayList<String> notInDictionary = service.findWordsFile("Homework8/bible.txt");
                        System.out.println("WORDS FROM THE FILE THAT ARE NOT PRESENT IN THE DICTIONARY:\n" + notInDictionary);
                    }
                    case 3 -> {
                       end = true;
                       break;
                    }
                    case 4-> {
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Something went wrong...Please try again!");
                    }
                }
                if(end) break;
            }
        }
    }
}
