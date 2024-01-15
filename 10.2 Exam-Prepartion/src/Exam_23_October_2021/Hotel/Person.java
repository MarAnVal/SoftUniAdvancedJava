package Exam_23_October_2021.Hotel;

public class Person {
    //name: String
    private String name;
    //id: int
    private int id;
    //age: int
    private int age;
    //hometown: String – "n/a" by default
    private String hometown = "n/a";

    //The class constructor should receive the name, id, age, and hometown.

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
//Override the toString() method in the following format:
    //"Person {name}: {id}, Age: {age}, Hometown: {hometown}"

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
    }
}
