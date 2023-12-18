package main;

public class Company {
    private static Company instance = new Company();
    // 참조변수는 비어있으면 널값이다.
    private Company() {}

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }
}
