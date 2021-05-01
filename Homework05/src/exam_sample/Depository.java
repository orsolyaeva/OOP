package exam_sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Depository {
    private final ArrayList<Product> products = new ArrayList<>();
    private static int numberWrongId = 0;

    public void readProduct(String filename){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(filename));
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("An error occurred whilst reading the file.");
            System.exit(1);
        }

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split(" ");
            this.products.add((new Product(Integer.parseInt(items[0].trim()), items[1].trim(),
                    Integer.parseInt(items[2].trim()))));
            this.products.get(products.size() - 1).setSpread(Integer.parseInt(items[3].trim()));
        }
    }

    public void readDepository(String filename){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(filename));
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("An error occurred whilst reading the file!");
            System.exit(2);
        }

        while(scanner.hasNextLine()){
            boolean correctId = false;
            String line = scanner.nextLine();
            String[] items = line.split(" ");
            int id = Integer.parseInt(items[0].trim());
            for(Product product:products){
                if(product.getId() == id){
                    correctId = true;
                   product.setNumber(Integer.parseInt(items[1].trim()));
                }
            }
            if(!correctId){
                numberWrongId += 1;
            }
        }

        System.out.println("Number of wrong Ids: " + numberWrongId);
    }

    public double sumPrice(){
        int sum = 0;
        for(Product product : products){
            sum += product.getPurchasePrice();
        }
        return sum;
    }

    public void greatestDifference(){
        double maximum =  Double.NEGATIVE_INFINITY;
        ArrayList<Product> greatestPriceDiff = new ArrayList<>();
        for(Product product:products){
            if(Math.abs(product.getPurchasePrice() - product.getShopPrice()) > maximum){
                maximum = Math.abs(product.getPurchasePrice() - product.getShopPrice());
                greatestPriceDiff.clear();
                greatestPriceDiff.add(product);
            }
            if(Math.abs(product.getPurchasePrice() - product.getShopPrice()) == maximum) {
                greatestPriceDiff.add(product);
            }
        }

        System.out.println("\nProducts with the greatest price difference: ");
        for(Product product:greatestPriceDiff){
            System.out.println(product);
        }
    }

    public void largestProfit(){
        double maximum = Double.NEGATIVE_INFINITY;
        Product profit = null;
        for(Product product:products){
            if(product.getShopPrice() * product.getNumber() > maximum){
                maximum = product.getShopPrice() * product.getNumber();
                profit = product;
            }
        }

        System.out.println("\nThe largest possible profit would be purchased from selling the following product: "
                + profit.toString());
    }

    @Override
    public String toString() {
        return "Depository{" +
                "products=" + products +
                '}';
    }
}
