package lab8_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("1. Array list\n2. Tree set\n3. Hash set\nEnter what kind of data structure you want to use: ");
        DictionaryService service = null;
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
            default -> {
                System.out.println("The given data structure does not exist!");
                System.exit(1);
            }
        }
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Word to find ( Enter <end> for exit): ");
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("end")) {
                break;
            }
            System.out.println(" Find(" + word + "): " + service.findWord(word));
        }

        ArrayList<String> notInDictionary = service.findWordsFile("Homework8/bible.txt");
        System.out.println("WORDS FROM THE FILE THAT ARE NOT PRESENT IN THE DICTIONARY:\n" + notInDictionary);
    }
}
