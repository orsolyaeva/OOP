package exam_sample;

public class Product {
    private int id;
    private String name;
    private double purchasePrice, shopPrice;

    public Product(int id, String name, double purchasePrice) {
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.shopPrice = this.purchasePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setSpread(double percentage){
        this.shopPrice = this.purchasePrice + this.purchasePrice * (percentage / 100);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", shopPrice=" + shopPrice +
                '}';
    }
}
