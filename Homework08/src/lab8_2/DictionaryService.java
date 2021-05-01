package lab8_2;

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

        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(filename));
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found: " + filename);
            System.exit(1);
        }

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

        return notInDictionary;
    }
}
