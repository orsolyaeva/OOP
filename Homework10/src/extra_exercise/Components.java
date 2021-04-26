package extra_exercise;

public abstract class Components {
    protected double price;

    public Components(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Components{" +
                "price=" + price +
                '}';
    }
}
