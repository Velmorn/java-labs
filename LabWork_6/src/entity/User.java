package entity;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void useComputer(Computer computer) {
        System.out.println(name + " (" + age + ") is using the computer");
        computer.run();
    }
}
