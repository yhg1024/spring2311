package exam01;

public class Ex01 {
    public static void main(String[] args) {
        // Integer num1 = new Integer(10);
        // Integer num2 = new Integer(10);

        // new Integer(10)은 10을 두번 만들고 Integer.valueof는 10의 값을 가르키는거라 낭비를 막는다.
        Integer num1 = Integer.valueOf(10);
        Integer num2 = Integer.valueOf(10);

        System.out.println(num1 == num2);
        System.out.println("num1 = " +System.identityHashCode(num1));
        System.out.println("num2 = " +System.identityHashCode(num2));

        // long num2 = num1.longValue();
    }
}
