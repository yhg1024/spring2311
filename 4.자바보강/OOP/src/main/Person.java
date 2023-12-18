package main;

public class Person {
    public String name;
    private double height;
    double weight;

    // 디폴트 생성자
    public Person() {
        this("이름 없음");

        this.showInfo();
    }

    public Person(String _name){
        name = _name;
        height = 0.0;
        weight = 0.0;
    }

    // 멤버변수 초기화
    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void showInfo() {
        System.out.println("이름 = " + name + ", 키 = " + height + ", 몸무게 = " + weight);
    }

    public void printThis() {
        System.out.println("this = " + System.identityHashCode(this));
    }

    public Person returnThis() {
        return this;
    }
}

