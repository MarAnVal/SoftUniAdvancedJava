package Exe07;

public class Company {
    //"{Name} company {companyName} {department} {salary}"
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        //{companyName} {companyDepartment} {salary}
        if (name.length() > 0) {
            return String.format("%n%s %s %.2f", this.name, this.department, this.salary);
        } else return "";
    }
}
