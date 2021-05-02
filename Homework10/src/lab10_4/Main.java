package lab10_4;

public class Main {
    public static void main(String[] args) throws ExpressionException {
        String expression1 = "1 2 + 3 2 + *";
        try {
            System.out.println( "Eval(" + expression1 + "): " + IExpression.evaluate( expression1 ));
        } catch (ExpressionException e) {
            System.out.println("\tWrong expression: " + expression1);
        }

    }
}
