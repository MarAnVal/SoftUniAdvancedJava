package Exam_18_February_2023.SoftUniKindergarten;

import java.util.ArrayList;
import java.util.List;

public class Kindergarten {
    //name: String
    private String name;
    //capacity: int
    private int capacity;
    //registry: List<Child>
    private List<Child> registry;

    // constructor should receive name and capacity,
    // also it should initialize the registry with a new instance of the collection

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    //Method addChild(Child child) - Adds a child to the registry if there is room
    // for it and returns true. If there is no room for another child, returns false.
    public boolean addChild(Child child) {
        if (this.capacity > this.registry.size()) {
            this.registry.add(child);
            return true;
        }
        return false;

    }

    //Method removeChild(String firstName) - removes a child by a given firstName.
    // If removal is successful, returns true, otherwise, returns false.
    public boolean removeChild(String firstName) {
        for (int i = 0; i < this.registry.size(); i++) {
            Child child = this.registry.get(i);
            if (child.getFirstName().equals(firstName)) {
                return this.registry.remove(child);
            }
        }
        return false;
    }

    //Getter getChildrenCount - Returns the number of all children registered.
    public int getChildrenCount() {
        return this.registry.size();
    }

    //Method getChild(String firstName) - Returns the child with the given first name.
    public Child getChild(String firstName) {
        for (int i = 0; i < this.registry.size(); i++) {
            Child child = this.registry.get(i);
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }
    //Method registryReport() – Orders the children by age ascending,
    // then by last name ascending, then by first name ascending,
    // and returns a String in the following format:
    //"Registered children in {kindergartenName}:
    //--
    //{child1}
    //--
    //{child2}
    //--
    //(…)
    //--
    //{childn}"
    public String registryReport(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("Registered children in %s:", this.name));
        for (int i = 0; i < this.registry.size(); i++) {
            text.append(System.lineSeparator());
            text.append("--");
            text.append(System.lineSeparator());
            text.append(this.registry.get(i));
        }
        return text.toString();
    }
}
