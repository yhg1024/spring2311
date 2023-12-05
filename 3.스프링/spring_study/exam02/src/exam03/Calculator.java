package exam03;

public abstract class Calculator {
    int num = 10; // 객체가 될때 공간이 만들어지면서 대입
    public abstract int add(int num1, int num2);

    public void commonMethod() {
        System.out.println("하위 클래스의 공통 기능");
    }
}
