package lab6_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {
    private final int capacity;

    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        return capacity == this.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void push(Object obj){
        if(isFull()){
            System.out.println("The stack is full! Can not add item " + obj + ".");
            return;
        }
        this.add(obj);
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("The stack is empty, there is no item to remove.");
            return;

        }
        this.remove(this.size() - 1);
    }

    public Object top(){
        if(isEmpty()){
            return null;
        }
        return this.get(this.size() - 1);
    }

    public int getSize(){
        return this.size();
    }
}
