package exam01;

import java.util.Calendar;

public class Ex01 {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(); // 다른 나라 달력체계로도 된다. java.util.GregorianCalendar
        showDate(cal);

        cal.set(Calendar.DAY_OF_MONTH, 10);
        showDate(cal);

        cal.add(Calendar.DAY_OF_MONTH, 100); // 100일 뒤
        showDate(cal);

        cal.add(Calendar.DAY_OF_MONTH, -100); // 100일 전, 위의 100일 뒤에서 100일 전
        showDate(cal);
    }

    private static void showDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0 ~ 11
        int date = cal.get(Calendar.DAY_OF_MONTH); // 일자

        System.out.printf("year=%d, month=%d, date=%d%n", year, month + 1, date);
    }
}
