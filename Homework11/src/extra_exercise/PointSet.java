package extra_exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PointSet {
    private ArrayList<Point> points = new ArrayList<>();

    public PointSet(int numPoints){
        Random rand = new Random();
        for(int i = 0; i < numPoints; i++){
            this.points.add(new Point((rand.nextDouble()-rand.nextDouble())*10,(rand.nextDouble()-rand.nextDouble())*10));
        }
    }

    public PointSet(String filename){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(filename));
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("FILE NOT FOUND: " + filename);
        }

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            StringTokenizer tokens = new StringTokenizer(line, ", ");

            double x = Double.parseDouble(tokens.nextToken());
            double y = Double.parseDouble(tokens.nextToken());

            this.points.add(new Point(x, y));
        }
    }

    public Point getPoint(int index) throws IndexOutOfBoundsException{
        return points.get(index);
    }

    public void print(){
        for(Point point : this.points){
            System.out.println(point);
        }
    }

    public void sort(Comparator<Point> comparator){
        points.sort(comparator);
    }

    public ArrayList<Point> getPoints(){
        return this.points;
    }
}
