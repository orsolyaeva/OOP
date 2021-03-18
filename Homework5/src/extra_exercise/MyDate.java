package extra_exercise;

import extra_exercise.utils.DateUtil;

import java.util.Properties;

public class MyDate {
    private int year, month, day;
    private String formatForPersonalId;
    private boolean valid;

    public MyDate(int year, int month, int day){
        if(!DateUtil.isValidDate(year, month, day)){
            this.valid = false;
            return;
        }
        this.valid = true;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getFormatForPersonalId() {
        return formatForPersonalId;
    }

    public boolean isValid() {
        return valid;
    }

    // returns the date object in a textual format
    public String toString(){
        return "Mydate: " + this.year + "-" + this.month + "-" + this.day;
    }
}
