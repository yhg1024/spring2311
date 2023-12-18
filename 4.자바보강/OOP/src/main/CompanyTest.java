package main;

public class CompanyTest {
    public static void main(String[] args) {
        Company com = Company.getInstance();
        Company com2 = Company.getInstance();

        System.out.println("com = " + com);
        System.out.println("com2 = " + com2);
        System.out.println(com == com2);
    }
}
