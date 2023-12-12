package exam01;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        // System.out.println(names); // 추가한 순서대로 반환

        /*for (int i = 0; i < names.size(); i++) {
            names.remove(i);
            // remove(i)는 순차적으로 올라가나 배열은 한칸씩 땡겨지므로 이름2와 이름4는 제거 되지 않는다.
            // 뒤에서부터 순서대로 삭제하면 다 삭제할수 있다.
        }*/

        for (int i = names.size() -1; i >= 0; i--) {
            String name = names.remove(i);
            System.out.println(name);
        }

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }
    }
}
