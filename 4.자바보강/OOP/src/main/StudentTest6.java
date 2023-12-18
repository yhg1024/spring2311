package main;

public class StudentTest6 {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("s1 = " + s1.studentId); // 1000

        Student s2 = new Student();
        System.out.println("s2 = " + s2.studentId); // 1001

        System.out.println("s1 = " + s1.studentId); // 1000
    }
}
