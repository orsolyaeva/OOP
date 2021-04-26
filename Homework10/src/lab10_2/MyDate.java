package lab10_2;

public class MyDate implements Comparable<MyDate>{
    private int year, month, day;

    public MyDate(int year, int month, int day){
        if(!DateUtil.isValidDate(year, month, day)){
            return;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // getter methods for each attribute
    public int getYear(){ return year; }

    public int getMonth(){ return month;}

    public int getDay() { return day;}

    // returns the date object in a textual format
    public String toString(){
        return this.year + "-" + this.month + "-" + this.day;
    }

    @Override
    public int compareTo(MyDate o) {
        if(o == null) throw new NullPointerException();

        if(this.year != o.year){
            return this.year - o.year;
        }

        if(this.month != o.month){
            return this.month - o.month;
        }

        if(this.day != o.day){
            return this.day - o.day;
        }

        return 0;
    }
}
