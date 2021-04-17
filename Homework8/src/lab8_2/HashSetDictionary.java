package lab8_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashSetDictionary implements IDictionary{
    private HashSet<String> words = new HashSet<>();
    private static HashSetDictionary instance = null;

    private HashSetDictionary(){
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
            instance = new HashSetDictionary();
        }else{
            System.out.println("You already have a Hash Set instance!");
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
        List<String> list = new ArrayList<String>(words);
        Collections.sort(list);
        words = (HashSet<String>) list;
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
