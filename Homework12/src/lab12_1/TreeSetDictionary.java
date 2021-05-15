package lab12_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDictionary implements IDictionary{
    private Set<String> words = new TreeSet<>();
    private static TreeSetDictionary instance = null;

    private TreeSetDictionary(){
        try(Scanner scanner = new Scanner(new File(DICTIONARY_FILE))){

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                words.add(line);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found: " + DICTIONARY_FILE);
            System.exit(1);
        }
    }

    public static IDictionary newInstance(){
        if(instance == null){
            instance = new TreeSetDictionary();
        } else{
            System.out.println("You already have a Tree Set instance!");
        }

        return instance;
    }

    @Override
    public boolean add(String s) {
        // we don't have to check if an element is already in the dictionary or not because in case of
        // tree sets duplicate elements are ignored, also in a tree set values are sorted in ascending order automatically
        words.add(s.toLowerCase());
        return true;
    }

    @Override
    public boolean find(String s) {
        return words.contains(s.toLowerCase());
    }

    @Override
    public int size() {
        return words.size();
    }
}
