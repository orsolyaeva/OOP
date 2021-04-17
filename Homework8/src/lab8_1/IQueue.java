package lab8_1;

public interface IQueue {
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract void enQueue(Object o);
    public abstract Object deQueue();
    public abstract void printQueue();
}
