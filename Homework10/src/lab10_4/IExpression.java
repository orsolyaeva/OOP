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

        int item;
        while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();

            if(isOperator(token)){
                int value1, value2;
                try {
                    value1 = (int) stack.top();
                    stack.pop();
                    value2 = (int) stack.top();
                    stack.pop();

                } catch (StackException e) {
                    e.printStackTrace();
                    throw new ExpressionException("Wrong postfix expression");
                }

                switch (token) {
                    case "+" -> {
                        try {
                            stack.push(value1 + value2);
                        } catch (StackException e) {
                            e.printStackTrace();
                        }
                    }
                    case "-" -> {
                        try {
                            stack.push(value1 - value2);
                        } catch (StackException e) {
                            e.printStackTrace();
                        }
                    }
                    case "*" -> {
                        try {
                            stack.push(value1 * value2);
                        } catch (StackException e) {
                            e.printStackTrace();
                        }
                    }
                    case "/" -> {
                        try {
                            System.out.println(" / " + value2 / value1);
                            stack.push(value2 / value1);
                        } catch (StackException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                try{
                    item = Integer.parseInt(token);
                } catch (NumberFormatException e){
                    throw new ExpressionException("Wrong operand: " + token);
                }

                try {
                    stack.push(item);
                } catch (StackException e) {
                    e.printStackTrace();
                }
            }
        }


        try {
            result = Double.parseDouble(stack.top().toString());
        } catch (StackException e) {
            e.printStackTrace();
        }

        return result;
    }
}
