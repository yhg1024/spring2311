package main;

public class StudentTest4 {
    public static void main(String[] args) {
        Student.serialNum = 1000;
        int serialNum = Student.serialNum;
        System.out.println(serialNum);


        Student s1 = new Student();
        s1.serialNum = 100;

        Student s2 = new Student();
        s2.serialNum = 1001;

        // 데이터가 1개라 값이 동일하다.
        System.out.println("s1.serialNum = " + s1.serialNum);
        System.out.println("s2.serialNum = " + s2.serialNum);
    }
}
