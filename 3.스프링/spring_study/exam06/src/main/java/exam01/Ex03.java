package exam01;

public class Ex03 {
    public static void main(String[] args) {

        try(MyResource my = new MyResource()) {
            // try () -> 괄호 안에 작성하면 AutoCloseable이 들어가서 자원반환이 자동으로 된다.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
