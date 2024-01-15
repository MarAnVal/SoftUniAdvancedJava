package Exam_16_December_2020.Openning;

public class Employee {
    //name: String
    private String name;
    //age: int
    private int age;
    //country: String
    private String country;

    //The class constructor should receive name, age and country
    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //ToString() method in the following format:
    //"Employee: {name}, {age} ({country})"

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", this.name, this.age, this.country);
    }
}
