package lab8_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListDictionary implements IDictionary{
    private ArrayList<String> words = new ArrayList<>();
    private static ArrayListDictionary instance = null;

    private ArrayListDictionary() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(DICTIONARY_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found: " + DICTIONARY_FILE);
            System.exit(1);
        }

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            words.add(line);
        }
    }

    public static IDictionary newInstance(){
        if(instance == null){
            instance = new ArrayListDictionary();
        }else{
            System.out.println("You already have an Array List instance!");
        }

        return instance;
    }

    @Override
    public boolean add(String s) {
       if(find(s)){
           System.out.println("The word is already in the dictionary!");
           return false;
       }

       words.add(s.toLowerCase());
       Collections.sort(words);
       return true;
    }

    @Override
    public boolean find(String s) {
        return Collections.binarySearch(words, s.toLowerCase()) >= 0;
    }

    @Override
    public int size() {
       return words.size();
    }
}
