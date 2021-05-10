package lab12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Storage {
    private Map<Integer, Product> products = new HashMap<>();

    public Storage(String filename) {
        try(Scanner scanner = new Scanner(new File(filename))){
            int id;
            StringTokenizer tokens;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                tokens = new StringTokenizer(line, " ");
                id = Integer.parseInt(tokens.nextToken());
                this.products.put(id, new Product(id, tokens.nextToken(),
                        Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found: " + filename);
            System.exit(1);
        }

    }

    public void update(String filename){
        try(Scanner scanner = new Scanner(new File(filename))){
            StringTokenizer tokens;
            int countUpdated = 0;

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                tokens = new StringTokenizer(line, " ");

                Product found = products.get(Integer.parseInt(tokens.nextToken()));

                if(found != null){
                    countUpdated += 1;
                    found.increaseAmount(Integer.parseInt(tokens.nextToken()));
                }
            }

            System.out.println(filename + ": " + countUpdated + " updates");

        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found: " + filename);
            System.exit(2);
        }

    }
}

