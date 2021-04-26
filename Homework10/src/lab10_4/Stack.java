package lab10_4;

import java.util.ArrayList;

public class Stack{
    private ArrayList<Object> items = new ArrayList<>();
    private final int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        return capacity == this.items.size();
    }

    public boolean isEmpty(){
        return this.items.size() == 0;
    }

    public void push(Object obj) throws StackException{
        if(isFull()){
            throw new StackException("Stack is full!");
        }
        this.items.add(obj);
    }

    public void pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty!");
        }
        this.items.remove(this.items.size() - 1);
    }

    public Object top() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty!");
        }
        return this.items.get(this.items.size() - 1);
    }

    public int getSize(){
        return this.items.size();
    }

    public void printStack(){
        if(!isEmpty()){
            for(Object o : items){
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }
}
