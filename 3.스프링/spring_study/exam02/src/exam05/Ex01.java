package exam05;

public class Ex01 {
    public static void main(String[] args) {
        Transportation trans = Transportation.SUBWAY;


        switch (trans) {
            case SUBWAY : // Transportation.SUBWAY라고 쓸 수 없다.
                System.out.println("지하철");
                break;
            case BUS:
                System.out.println("버스");
                break;
            case TAXI:
                System.out.println("택시");
                break;
        }

        /*if (trans == Transportation.SUBWAY) {
            System.out.println("지하철");
        }*/
    }
}
