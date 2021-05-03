package extra_exercise;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Point implements Comparable<Point>{
    private final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double slopeTo(Point that){
        double angle = (double)Math.toDegrees(Math.atan2(that.x - x, that.y - y));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return "("+ formatter.format(x) + ", " + formatter.format(y) + ")";
    }

    @Override
    public int compareTo(Point o) {
        if(o.y != this.y){
            return (int)(this.y - o.y);
        }
        return (int)(this.x - o.x);
    }
}
