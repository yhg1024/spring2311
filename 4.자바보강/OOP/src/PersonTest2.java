import main.Person;

public class PersonTest2 {
    public static void main(String[] args) {
        Person person = new Person();

        // System.out.println(person);
        System.out.println("pserson = " + System.identityHashCode(person));

        System.out.println(person == person.returnThis());

        person.printThis();
    }
}
