package homework;

public class Rectangle {
    private double length, width;

    public Rectangle(double length, double width){
        if(length > 0 && width > 0){
            this.length = length;
            this.width = width;
        }
    }

    public double perimeter(){
        return 2 * (width + length);
    } // method that return the perimeter of the rectangle

    public double area(){
        return width * length;
    } // method that return tha area of the rectangle

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }
}
