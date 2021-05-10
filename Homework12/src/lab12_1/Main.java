package lab12_1;

/**
 * Hash set is faster than TreeSet and should be the preferred choice if sorting elements is NOT required.
 * For operations like search, insert and delete it takes constant time for these operations on average.
 * Elements in HashSet are not ordered.
 *
 * TreeSet takes O(Log n) for search, insert and delete which is higher than HashSe, but TreeSet keeps sorted data.
 * TreeSet elements are sorted in ascending order by default.
 *
 * In case of a dictionary I prefer TreeSets over HashSets because we require SORTED and UNIQUE elements, instead of
 * unique elements.
 */

public class Main {
    public static void main(String[] args) {
        long startTime, endTime, timeElapsed;
        DictionaryService service;

        // measure the time elapsed using ArrayList
        startTime = System.nanoTime();
        service = new DictionaryService(DictionaryType.ARRAY_LIST);
        service.findWordsFile("Homework12/bible.txt");
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("ArrayList execution time: " + timeElapsed / 1000000 + " ms");

        // measure the time elapsed using TreeSet
        startTime = System.nanoTime();
        service = new DictionaryService(DictionaryType.TREE_SET);
        service.findWordsFile("Homework12/bible.txt");
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("TreeSet execution time: " + timeElapsed / 1000000 + " ms");

        // measure the time elapsed using HashSet
        startTime = System.nanoTime();
        service = new DictionaryService(DictionaryType.HASH_SET);
        service.findWordsFile("Homework12/bible.txt");
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("HashSet execution time: " + timeElapsed / 1000000 + " ms");
    }
}
