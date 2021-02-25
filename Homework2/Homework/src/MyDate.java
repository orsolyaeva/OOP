public class MyDate {
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
        return "Mydate: " + this.year + "-" + this.month + "-" + this.day;
    }

}