package main;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public void setYear(int _year) {
        this.year = _year;
    }

    public void setMonth(int _month) {
        if (_month < 1) {
            _month = 1;
        } else if (_month > 12) {
            _month = 12;
        }
        month = _month;
    }

    public void setDay(int _day) {
        if (month == 2) {
            if (_day > 28) {
                _day = 28;
            } else if (_day <= 0) {
                _day = 1;
            }
        }
        day = _day;
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

    public void showDate() {
        System.out.println(year + "-" + month + "-" + day);
    }
}
