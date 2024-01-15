package Exe02;

public class Employee {
    //name, salary, position, department, email, and age.
    //The name, salary, position, and department are mandatory, while the rest are optional.
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Double getSalary() {
        return salary;
    }

    public Employee(String name, Double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        //{name2} {salary2} {email2} {age2}
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
