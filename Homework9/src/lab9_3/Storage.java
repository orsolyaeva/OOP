package lab9_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Storage {
    private ArrayList<Product> products = new ArrayList<>();

    public Storage(String filename) {
       Scanner scanner = null;
       try{
           scanner = new Scanner(new File(filename));
       } catch (FileNotFoundException e){
           e.printStackTrace();
           System.out.println("File not found: " + filename);
           System.exit(1);
       }

        StringTokenizer tokens;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            tokens = new StringTokenizer(line, " ");
            this.products.add(new Product(Integer.parseInt(tokens.nextToken()), tokens.nextToken(),
                    Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
        }

        products.sort(Product::compareTo);
    }

    public void update(String filename){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found: " + filename);
            System.exit(2);
        }

        StringTokenizer tokens;
        int countUpdated = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            tokens = new StringTokenizer(line, " ");

            int bSearch = Collections.binarySearch(products, new Product(Integer.parseInt(tokens.nextToken()), null, 0, 0));
            if(bSearch >= 0){
                countUpdated += 1;
                products.get(bSearch).increaseAmount(Integer.parseInt((tokens.nextToken())));
            }
        }

        System.out.println(filename + ": " + countUpdated + " updates");
    }
}
