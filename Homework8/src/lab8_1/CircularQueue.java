package lab8_1;

import java.util.Arrays;
import java.util.Objects;

public class CircularQueue implements IQueue {
    private final int CAPACITY;
    private int front, rear; // track the first and the last element of the queue
    private Object[] items;

    public CircularQueue(int capacity) {
        CAPACITY = capacity;
        items = new Object[CAPACITY];
        // initially set value of front and rear to -1
        this.front = -1;
        this.rear = -1;
    }

    // check if the queue is empty
    @Override
    public boolean isEmpty() {
        return this.front == -1;
    }

    // check if the queue is full
    @Override
    public boolean isFull() {
        if (this.front == 0 && this.rear == CAPACITY - 1) {
            return true;
        }

        return this.front == this.rear + 1;
    }

    // add a new element
    @Override
    public void enQueue(Object o) {
        if (isFull()) {
            System.out.println("The queue is full!");
        } else {
            if (this.front == -1) {
                this.front = 0;
            }
            this.rear = (this.rear + 1) % CAPACITY;
            items[this.rear] = o;
            System.out.println("Inserted " + o);
        }
    }

    @Override
    public Object deQueue() {
        Object element;
        if (isEmpty()) {
            System.out.println("The queue is empty!");
            return null;
        } else {
            element = this.items[front];
            if (this.front == this.rear) { // queue has one element so we reset the queue after deleting it
                this.front = -1;
                this.rear = -1;
            } else {
                this.front = (this.front + 1) % CAPACITY;
            }
            return element;
        }
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }
        System.out.print("CircularQueue [ array:[");
        int i;
        for(i = 0; i < items.length - 1; i++){
            System.out.print(items[i] + ", ");
        }
        System.out.print(items[i] + " ], front: "+ this.front+ ", rear: "+ this.rear + " ]\n");
    }

    @Override
    public boolean equals(Object o) {
       CircularQueue temp = (CircularQueue) o;
       if(CAPACITY != temp.CAPACITY){
           return false;
       }

       int i, j;

       if(items[rear] != temp.items[temp.rear]){
           return false;
       }

       for(i = front, j = temp.front; i != rear && j != temp.rear; i = (i + 1) % CAPACITY, j = (j + 1) % temp.CAPACITY){
           if(items[i] != temp.items[j]){
               return false;
           }
       }

       return true;
    }



    @Override
    public int hashCode() {
        int result = Objects.hash(CAPACITY, front, rear);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}

