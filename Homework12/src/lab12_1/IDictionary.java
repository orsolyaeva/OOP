package lab12_1;

public interface IDictionary {
    public static final String DICTIONARY_FILE = "Homework12/dictionary.txt";

    public abstract boolean add(String s);
    public abstract boolean find(String s);
    public abstract int size();
}
