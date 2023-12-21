package exam02;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public int getYear() { // getter
        return year;
    }

    public void setYear(int year) { // setter
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (month == 2) {
            if (day > 28) {
                day = 28;
            }
        }
        if (day > 30) {
            day = 30;
        }
        this.day = day;
    }

    void showDate() {
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }
}
