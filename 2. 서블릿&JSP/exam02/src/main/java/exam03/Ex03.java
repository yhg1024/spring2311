package exam03;

public class Ex03 {
    public static void main(String[] args) {
        A a1 = new C();

        A a2 = new D();

        if(a2 instanceof C) {
            // C c1 = a2; 상위클래스가 하위클래스를 못 받는다.
            C c1 = (C) a2; // 형변환해준다
        }
    }
}
