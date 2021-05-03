package extra_exercise;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        main1();
        PointSet pointSet = new PointSet("Homework11/points.txt");
        Point origo = new Point(0, 0);

        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("Angles between the slope and abscissa: ");

        for(Point point : pointSet.getPoints()){
            System.out.println("\t" + point + "\t angle: " + point.slopeTo(origo));
        }

        pointSet.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.slopeTo(origo) == o2.slopeTo(origo)){
                    return (int)((Math.sqrt(Math.pow(o1.getX(), 2) + Math.pow(o1.getY(), 2)))
                    - (Math.sqrt(Math.pow(o2.getX(), 2) + Math.pow(o2.getY(), 2))));
                }
                return (int)(o1.slopeTo(origo) - o2.slopeTo(origo));
            }
        });

        System.out.println("\nPoints after sorting: ");
        pointSet.print();
    }

    public static void main1(){
        TreeSet<Point> points = new TreeSet<>();
        Random rand = new Random();

        while(points.size() < 10){
            points.add(new Point((rand.nextDouble()-rand.nextDouble())*10,(rand.nextDouble()-rand.nextDouble())*10));
        }

        for(Point point : points){
            System.out.println(point);
        }
    }
}

