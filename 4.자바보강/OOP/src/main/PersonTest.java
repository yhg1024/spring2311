package main;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("이승훈", 178, 70);

        Person person2 = new Person("양형경", 164, 73);

        person1.showInfo();
        person2.showInfo();

        Person person3 = new Person("이름");
        person3.showInfo();

    }
}
