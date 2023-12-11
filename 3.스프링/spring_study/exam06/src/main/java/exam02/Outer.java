package exam02;

public class Outer {

    Calculator method(int num3) { // void로 쓰면 활용도가 떨어진다. Calculator로 외부에서 동일한 객체자원을 받아서 활용도가 높아진다. 반환값 형태로 사용
        /*Calculator cal = new Calculator() { */
        return new Calculator() { // 익명 내부클래스: 참조 변수가 없는 상태, 생성해서 바로 반환
            @Override
            public int add(int num1, int num2) {
                // num3 = 40; final이 붙어야해서 안된다.
                return num1 + num2 + num3;
            }
        };

        /*int result = cal.add(10,20);
        System.out.println(result);*/
        /*return cal; 용도가 반환값만 쓰이는건 아까우니 바로 리턴한다.*/
    }

    /*void method() {
        class Inner {
            void innerMethod() {
                System.out.println("지역 내부 클래스"); // 지역 내부로 한정이라 잘 쓰지 않는다.
            }
        }

        Inner in = new Inner();
        in.innerMethod();
    }*/
}
