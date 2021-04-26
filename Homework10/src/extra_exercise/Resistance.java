package extra_exercise;

import java.util.Objects;

public class Resistance extends Components{
    private double value;

    public Resistance(double price, double value) {
        super(price);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Resistance{" +
                "price=" + price +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resistance that = (Resistance) o;
        return Double.compare(that.value, value) == 0;
    }
}
