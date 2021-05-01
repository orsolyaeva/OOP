package exam_sample;

public class Main {
    public static void main(String[] args) {
//        Product product = new Product(1234, "Apple", 5);
//        product.setSpread(10);
//        System.out.println(product);
//
        Depository depository = new Depository();
        depository.readProduct("Homework5/products.txt");
        System.out.println(depository.toString());

        System.out.println("\n***********************\n");
        depository.readDepository("Homework5/depository.txt");
        System.out.println(depository.toString());

        System.out.println("Sum of the products prices = " + depository.sumPrice());
        depository.greatestDifference();
        depository.largestProfit();
    }
}
