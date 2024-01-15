package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        TreeSet<Person> nameSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new AgeComparator());
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            Person person = new Person(line.split("\\s+")[0], Integer.parseInt(line.split("\\s+")[1]));
            nameSet.add(person);
            ageSet.add(person);
        }
        nameSet.forEach(p -> System.out.println(p));
        ageSet.forEach(p -> System.out.println(p));
    }
}
