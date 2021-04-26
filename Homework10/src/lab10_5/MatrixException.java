package lab10_5;

public class MatrixException extends Exception{
    public MatrixException(String message) {
        super(message);
        System.out.println(message);
    }
}
