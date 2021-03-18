package exam_sample;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1234, "Apple", 5);
        product.setSpread(10);
        System.out.println(product);
    }
}
