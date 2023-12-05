package exam04;

public interface Calculator {
    int num = 10; // public static final
    int add(int num1, int num2); // 앞에 자동으로 public abstract 추가된다.

    default int minus(int num1, int num2){
        return num1 - num2;
    }
}
