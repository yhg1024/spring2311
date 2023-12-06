package exam01;

public class Ex02 {
    public static void main(String[] args) {
        String str = "TAXI";

        // T valueOf(Class<T>enumType, String name) : 지정된 열거형에서 name값과 일치하는 열거형 상수를 반환한다.
        // valueOf : 변환 메서드 (문자열 -> Enum 상수 )
        Transportation trans = Enum.valueOf(Transportation.class, str);
        System.out.println(trans);

        // 컴파일러가 자동으로 추가해주는 메서드
        // 열거형 상수의 이름으로 문자열 상수에 대한 참조를 얻을 수 있게 해준다.
        Transportation trans2 = Transportation.valueOf(str);
        System.out.println(trans2);

    }
}
