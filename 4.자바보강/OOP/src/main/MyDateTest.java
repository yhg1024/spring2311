package main;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        // date.year = 2003;
        // date.month = 12;
        // date.day = 16;

        date.setYear(2023);
        date.setMonth(2);
        date.setDay(31);

        System.out.println(date.getDay());

        date.showDate();
    }
}
