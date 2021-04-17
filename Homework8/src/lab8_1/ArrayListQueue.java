package lab8_1;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue{
    private ArrayList<Object> items = new ArrayList<>();
    private final int CAPACITY;

    public ArrayListQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public boolean isFull() {
        return items.size() == CAPACITY;
    }

    @Override
    public void enQueue(Object o) {
        if(isFull()){
            System.out.println("The queue is full!");
            return;
        }
        this.items.add(o);
    }

    @Override
    public Object deQueue() {
       if(isEmpty()){
           System.out.println("The queue is empty!");
           return null;
       }
       return items.remove(0);
    }

    @Override
    public void printQueue() {
        System.out.println("ArrayListQueue:" + items.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListQueue that = (ArrayListQueue) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, CAPACITY);
    }


}
