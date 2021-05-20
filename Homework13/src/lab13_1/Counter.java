package lab13_1;

public class Counter {
    private int value;

    public Counter(){
    }

    public Counter(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void inc(){
        ++value;
    }
}
