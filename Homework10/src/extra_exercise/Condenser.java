package extra_exercise;

public class Condenser extends Components{
    private double value;

    public Condenser(double price, double value) {
        super(price);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Condenser{" +
                "price=" + price +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condenser condenser = (Condenser) o;
        return Double.compare(condenser.value, value) == 0;
    }
}
