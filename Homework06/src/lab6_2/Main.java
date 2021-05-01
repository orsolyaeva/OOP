package lab6_2;

import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StackAggregation stack1 = new StackAggregation( 5 );
        for( int i=0; i<10; ++i ){
            stack1.push( i );
        }
        System.out.print("StackAggregation : ");
        while( !stack1.isEmpty() ){
            System.out.print( stack1.top() + " ");
            stack1.pop();
        }
        System.out.println();


        System.out.println();
        StackInheritance stack2 = new StackInheritance( 5 );
        for( int i=0; i < 10; ++i ){
            stack2.push( i );
        }
//        stack2.remove( 1 );
        System.out.print("\nStackInheritance : ");
        while( !stack2.isEmpty() ){
            System.out.print( stack2.top() + " ");
            stack2.pop();
        }
        System.out.println();
    }
}
