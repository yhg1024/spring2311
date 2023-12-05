package exam05;

public class Ex03 {
    public static void main(String[] args) {
        Transportation bus = Transportation.BUS;
        System.out.printf("ordinal: %d, name: %s%n", bus.ordinal(), bus.name());
        // ordinal 값 : 열거 순서, bus가 가장 먼저 열어되서 0번
        // name 값은 문자열 상수

        Transportation subway = Transportation.valueOf( "SUBWAY");
        System.out.println(subway);
    }
}
