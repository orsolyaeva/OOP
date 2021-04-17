package lab8_2;

public interface IDictionary {
    public static final String DICTIONARY_FILE = "Homework8/dictionary.txt";

    public abstract boolean add(String s);
    public abstract boolean find(String s);
    public abstract int size();
}
