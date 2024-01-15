package StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() - o2.getName().length() != 0) {
            return o1.getName().length() - o2.getName().length();
        } else {
            String nameO1 = o1.getName().toLowerCase();
            String nameO2 = o2.getName().toLowerCase();
            return nameO1.charAt(0) - nameO2.charAt(0);
        }
    }
}
