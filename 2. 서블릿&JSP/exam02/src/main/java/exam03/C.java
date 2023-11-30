package exam03;

public class C extends B{
    int numC = 30;

    public C(){
        super(); // 상위클래스 기본생성자 호출 : B()
        System.out.println("C 생성자!");
    }

}
