package Project;

import java.util.GregorianCalendar;

public class Date {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        String date = year + "-" + month + "-" + day;
        return date;
    }

    public Date(int day, int month, int year) {
        GregorianCalendar cal = new GregorianCalendar();
        try {
            if (day > 31 || month > 12 || (day == 31 && month == 2) || (day == 30 && month == 2) || (day == 31 && month == 4) || (day == 31 && month == 6) || (day == 31 && month == 9) || (day == 31 && month == 11)) {
                throw new Exception("This day never happened.");
            } else if (!cal.isLeapYear(year) && day == 29 && month == 2) {
                throw new Exception("This day never happened.");
            } else if (year > 2022 || year < 1900) {
                throw new Exception("Bad year.");
            } else {
                this.day = day;
                this.month = month;
                this.year = year;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
