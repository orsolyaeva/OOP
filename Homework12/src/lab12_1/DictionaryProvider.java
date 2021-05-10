package lab12_1;

public class DictionaryProvider{
    public static IDictionary createDictionary(DictionaryType dictionaryType){
        switch (dictionaryType.ordinal() + 1) {
            case 1 -> {
                return ArrayListDictionary.newInstance();
            }
            case 2 -> {
                return TreeSetDictionary.newInstance();
            }
            case 3 -> {
                return HashSetDictionary.newInstance();
            }
            default -> {
                System.out.println("The given data structure does not exist! Try again!");
                createDictionary(dictionaryType);
            }
        }

        return null;
    }
}
