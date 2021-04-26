package extra_exercise;

import java.util.Objects;

public class Transistor extends Components{
    private String code;

    public Transistor(double price, String code) {
        super(price);
        this.code = code;
    }

    @Override
    public String toString() {
        return "Transistor{" +
                "price=" + price +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transistor that = (Transistor) o;
        return Objects.equals(code, that.code);
    }
}
