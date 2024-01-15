package Exam_19_February_2022.Parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    //name: String
    private String name;
    //capacity: int
    private int capacity;
    //data: List<Parrot> that holds added parrots
    private List<Parrot> data;

    //The class constructor should receive (name, capacity),
    // also it should initialize the data with a new instance of the collection.

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //getName()
    public String getName() {
        return name;
    }

    //getCapacity()
    public int getCapacity() {
        return capacity;
    }

    //add(Parrot parrot) method - adds an entity to the data if there is room for it
    public void add(Parrot parrot) {
        if (this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }

    //remove(String name) method - removes a parrot by given name, if such exists, and returns boolean
    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            Parrot current = this.data.get(i);
            if (current.getName().equals(name)) {
                return this.data.remove(current);
            }
        }
        return false;
    }

    //sellParrot(String name) method - sell (set its available property to false without
    // removing it from the collection) the first parrot with the given name, also return the parrot
    public Parrot sellParrot(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            Parrot current = this.data.get(i);
            if (current.getName().equals(name) && current.isAvailable()) {
                current.setAvailable(false);
                return current;
            }
        }
        return null;
    }

    //sellParrotBySpecies(String species) method - sells and returns all parrots from that species as a List
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            Parrot current = this.data.get(i);
            if (current.getSpecies().equals(species)) {
                parrots.add(current);
                current.setAvailable(false);
            }
        }
        return parrots;
    }

    //count() - returns the number of parrots
    public int count() {
        return this.data.size();
    }

    //report() - returns a String in the following format, including only not sold parrots:
    //"Parrots available at {cageName}:
    //{Parrot 1}
    //{Parrot 2}
    //(…)"
    public String report() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Parrots available at %s:", this.name));
        for (int i = 0; i < this.data.size(); i++) {
            Parrot current = this.data.get(i);
            if (current.isAvailable()) {
                text.append(System.lineSeparator());
                text.append(current.toString());
            }
        }
        return text.toString();
    }
}
