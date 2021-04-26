package lab10_2;

public class DateUtil {
    // the leapYear method checks whether its parameter is leap year
    public static boolean leapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    // the isValid method checks whether its parameters (year, month, day) from a valid date
    public static boolean isValidDate(int year, int month, int day){
        // if the year, month or day is out of range
        if(year <= 0){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        if(day < 1 || day > 31){
            return false;
        }

        // handle February month with leap year
        if(month == 2){
            if(leapYear(year)){
                return (day <= 29);
            }
            return (day <= 28);
        }

        // months April, June, September and November must have 30 days
        if(month == 4 || month == 6 || month == 9 || month == 11){
            return (day <= 30);
        }

        return true;
    }
}
