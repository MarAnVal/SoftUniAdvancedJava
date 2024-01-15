package Exam_18_August_2021.Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    //employees : List<Employee>
    private List<Employee> employees;
    //name: String
    private String name;
    //capacity: int
    private int capacity;

    // constructor should receive the name and capacity,
    // also it should initialize the employees with a new instance of the collection

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    //Method addEmployee(Employee employee) – adds an entity to the data if there is room for him/her.
    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    //Method removeEmployee(String name) – removes an employee by given name, if such exists, and returns a bool.
    public boolean removeEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            Employee employee = this.employees.get(i);
            if (employee.getName().equals(name)) {
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    //Method getOldestEmployee() – returns the oldest employee.
    public Employee getOldestEmployee() {
        if (employees.size() > 0) {
            Employee employee = this.employees.get(0);
            for (int i = 1; i < this.employees.size(); i++) {
                Employee current = this.employees.get(i);
                if (current.getAge() > employee.getAge()) {
                    employee = current;
                }
            }
            return employee;
        }
        return null;
    }

    //Method getEmployee(string name) – returns the employee with the given name.
    public Employee getEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            Employee employee = this.employees.get(i);
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
    //Getter getCount() – returns the number of employees.
    public int getCount() {
        return employees.size();
    }
    //report() – returns a string in the following format:
    //"Employees working at Cafe {cafeName}:
    //{Employee1}
    //{Employee2}
    //(…)"
    public String report(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("Employees working at Cafe %s:", this.name));
        for (int i = 0; i < this.employees.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.employees.get(i));
        }
        return text.toString();
    }
}
