package exam03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("data.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            // 순서대로 넣어야한다.
            // 순서가 달라지면 오류가 나서 되도록 자료형은 하나로 하자
            boolean result = dis.readBoolean();
            int number = dis.readInt();
            String str = dis.readUTF();

            System.out.printf("result=%s, num=%d, str=%s%n", result, number, str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
