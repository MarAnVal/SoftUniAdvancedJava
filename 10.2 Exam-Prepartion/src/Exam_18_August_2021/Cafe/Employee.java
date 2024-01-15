package Exam_18_August_2021.Cafe;

public class Employee {
    //name: String
    private String name;
    //age: int
    private int age;
    //country: String
    private String country;
    //constructor should receive name, age and country

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    //ToString() method in the following format:
    //"Employee: {name}, {age} from {country}"

    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s", this.name, this.age, this.country);
    }
}
