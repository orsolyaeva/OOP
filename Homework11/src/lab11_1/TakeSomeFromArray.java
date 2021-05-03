package lab11_1;

public class TakeSomeFromArray extends Thread{
    private String[] sa_array;
    private String givenString;
    private int limit;
    private static int countReplace = 0;

    public TakeSomeFromArray(String[] sa_array, String givenString, int limit) {
        this.sa_array = sa_array;
        this.givenString = givenString;
        this.limit = limit;
    }

    @Override
    public void run(){
        while(countReplace < limit && AddToArray.countChanges < AddToArray.changeMax){
            replace();
        }

        if(countReplace == limit){
            System.out.println("String " + givenString + " has been replaced " + limit + " times, thread finished its work.");
        }

        if(AddToArray.countChanges == AddToArray.changeMax){
            System.out.println("Thread stopped running.");
            this.interrupt();
        }
    }

    public synchronized void replace(){
        for(int i = 0; i < sa_array.length; i++){
            if(sa_array[i].equals(givenString)){
                countReplace += 1;
                System.out.println("String " + givenString + " has been replaced with space "+ countReplace + " times.");
                sa_array[i] = " ";
                AddToArray.countChanges += 1;
            }
        }
    }

}
