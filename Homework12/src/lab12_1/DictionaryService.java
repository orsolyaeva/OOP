package lab12_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DictionaryService {
    private IDictionary dictionary;

    public DictionaryService(DictionaryType dictionaryType) {
        this.dictionary = DictionaryProvider.createDictionary(dictionaryType);
    }

    public boolean findWord(String s) {
        return dictionary.find(s);
    }

    public ArrayList<String> findWordsFile(String filename){
        ArrayList<String> notInDictionary = new ArrayList<>();

        // try with resources
        try (Scanner scanner = new Scanner(new File(filename))){
            StringTokenizer tokens;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                tokens = new StringTokenizer(line, ":;-,.?!()' ");
                while(tokens.hasMoreTokens()){
                    String temp = tokens.nextToken();
                    if(!dictionary.find(temp) && !notInDictionary.contains(temp)){
                        notInDictionary.add(temp);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found: " + filename);
            System.exit(1);
        }

        return notInDictionary;
    }
}
