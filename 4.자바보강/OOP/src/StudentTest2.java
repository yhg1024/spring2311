public class StudentTest2 {
    public static void main(String[] args) {
        Student student1 = new Student(); // 생성자
        student1.studentId = 1000;
        student1.studentName = "이학생";
        student1.address = "인천광역시";

        student1.showStudentInfo();
        System.out.println(student1);

        Student student2 = new Student(); // 생성자
        student2.studentId = 1001;
        student2.studentName = "김학생";
        student2.address = "서울특별시";

        student2.showStudentInfo();
        System.out.println(student2);
    }
}
