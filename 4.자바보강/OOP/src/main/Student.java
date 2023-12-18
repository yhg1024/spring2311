package main;

public class Student {
    static int serialNum = 1000; // 정적변수
    // 맴버변수
    int studentId;
    String studentName;
    int grade;
    String address; // 사는곳

    public Student() {
        studentId = serialNum++;
    }

    // 메서드
    public void showStudentInfo() {
        System.out.println(studentName + "," + address);
    }

    public static void showStaticStudentInfo() {
        // System.out.println("static 메서드에서 호출");
        // System.out.println(studentName + "," + address);
        //Student s = new Student();
        //System.out.println(s.studentName + "," + s.address);
        serialNum++;
    }
}
