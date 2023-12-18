package main;

public class StudentTest5 {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.serialNum); // 1001

        Student s2 = new Student();
        System.out.println(s2.serialNum); // 1002

        System.out.println(s1.serialNum); // 1002
    }
}
