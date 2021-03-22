package lab6_2;

import java.util.ArrayList;

public class StackAggregation {
    private ArrayList<Object> items = new ArrayList<>();
    private final int capacity;

    public StackAggregation(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        return capacity == this.items.size();
    }

    public boolean isEmpty(){
        return this.items.size() == 0;
    }

    public void push(Object obj){
        if(!isFull()){
            this.items.add(obj);
        }
        else{
            System.out.println("The stack is full! Can not add item " + obj + ".");
        }
    }

    public void pop(){
        if(!isEmpty()){
            this.items.remove(this.items.size() - 1);
        }
        else{
            System.out.println("The stack is empty, there is no item to remove.");
        }
    }

    public Object top(){
        if(isEmpty()){
            return null;
        }
        return this.items.get(this.items.size() - 1);
    }

    public int getSize(){
        return this.items.size();
    }
}
