package main;

public class StudentTest3 {
    public static void main(String[] args) {
        Student student1 = new Student(); // 생성자
        student1.studentId = 1000;
        student1.studentName = "이학생";
        student1.address = "인천광역시";

        student1.showStudentInfo();

        Student student2 = student1; // student1에 있는 주소값
        student2.studentName = "김학생";

        student2.showStudentInfo();
        student1.showStudentInfo();

        System.out.println(student1);
        System.out.println(student2);
    }
}
