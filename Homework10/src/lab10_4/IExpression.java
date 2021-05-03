package lab10_4;

import java.util.StringTokenizer;

public interface IExpression {
    static boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    static double evaluate(String postFixExpression) throws ExpressionException{
        Stack stack = new Stack(postFixExpression.length());
        double result = Double.NaN;

        StringTokenizer tokens = new StringTokenizer(postFixExpression, " ");

        double item;
        while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();

            if(isOperator(token)){
                double value1, value2;
                try {
                    value1 = (double) stack.top();
                    stack.pop();
                    value2 = (double) stack.top();
                    stack.pop();

                } catch (StackException e) {
                    throw new ExpressionException("Wrong postfix expression!");
                }

                switch (token) {
                    case "+" -> {
                        try {
                            stack.push(value1 + value2);
                        } catch (StackException e) {
                           throw new ExpressionException("Wrong postfix expression!");
                        }
                    }
                    case "-" -> {
                        try {
                            stack.push(value1 - value2);
                        } catch (StackException e) {
                            throw new ExpressionException("Wrong postfix expression!");
                        }
                    }
                    case "*" -> {
                        try {
                            stack.push(value1 * value2);
                        } catch (StackException e) {
                            throw new ExpressionException("Wrong postfix expression!");
                        }
                    }
                    case "/" -> {
                        try {
                            stack.push(value2 / value1);
                        } catch (StackException e) {
                            throw new ExpressionException("Wrong postfix expression!");
                        }
                    }
                }

            } else {
                try{
                    item = Double.parseDouble(token);
                } catch (NumberFormatException e){
                    throw new ExpressionException("Wrong operand: " + token);
                }

                try {
                    stack.push(item);
                } catch (StackException e) {
                   throw new ExpressionException("This should never happen!\n");
                }
            }
        }


        try {
            result = Double.parseDouble(stack.top().toString());
        } catch (StackException e) {
            throw new ExpressionException("Wrong postfix expression!");
        }

        return result;
    }
}
