package Exe02;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, List<Employee>> departmentEmployeeMap = new HashMap<>();
        Map<String, Double> departmentAverageSalaryMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];
            String email = "n/a";
            int age = -1;
            if (line.length == 5) {
                String text = line[4];
                if (isItDigits(text)) {
                    age = Integer.parseInt(text);
                } else {
                    email = text;
                }
            } else if (line.length == 6) {
                email = line[4];
                age = Integer.parseInt(line[5]);
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            departmentEmployeeMap.putIfAbsent(department, new ArrayList<>());
            departmentEmployeeMap.get(department).add(employee);
            departmentAverageSalaryMap.putIfAbsent(department, 0.0);
            if (departmentAverageSalaryMap.get(department) == 0) {
                departmentAverageSalaryMap.put(department, salary);
            } else {
                departmentAverageSalaryMap.put(department, (departmentAverageSalaryMap.get(department) + salary) / 2);
            }
        }
        departmentAverageSalaryMap = departmentAverageSalaryMap.entrySet().stream().
                sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        List<Employee> result = new ArrayList<>();
        for (Map.Entry<String, Double> entry : departmentAverageSalaryMap.entrySet()) {
            //"Highest Average Salary: {department}
            //{name1} {salary1} {email1} {age1}
            //{name2} {salary2} {email2} {age2}
            //…
            //{namen} {salaryn} {emailn} {agen}"
            System.out.printf("Highest Average Salary: %s%n", entry.getKey());
            result = departmentEmployeeMap.get(entry.getKey());
            break;
        }
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i).getSalary() < result.get(i + 1).getSalary()) {
                Employee buffer = result.get(i);
                result.set(i, result.get(i + 1));
                result.set(i + 1, buffer);
                i = -1;
            }

        }

        result.forEach(e -> System.out.println(e.toString()));
    }

    public static boolean isItDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

