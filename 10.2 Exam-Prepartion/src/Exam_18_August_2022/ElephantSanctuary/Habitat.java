package Exam_18_August_2022.ElephantSanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    //capacity: int
    //Field data – List that holds added elephants
    private int capacity;
    private List<Elephant> data;

    //constructor should receive capacity. Also, it should initialize the data with a new collection instance.

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //Method add(Elephant elephant) – adds an entity to the data if there is an empty space for the elephant.
    public void add(Elephant elephant) {
        if (this.capacity > this.data.size()) {
            this.data.add(elephant);
        }
    }

    //Method remove(String name) – removes the elephant by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            Elephant currentElephant = this.data.get(i);
            if (currentElephant.getName().equals(name)) {
                return this.data.remove(currentElephant);
            }
        }
        return false;
    }

    //Method getElephant(String retiredFrom) – returns the elephant retired from the
    // given place or null if no such elephant exists.
    public Elephant getElephant(String retiredFrom) {
        for (int i = 0; i < this.data.size(); i++) {
            Elephant currentElephant = this.data.get(i);
            if (currentElephant.getRetiredFrom().equals(retiredFrom)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    //Method getOldestElephant() – returns the oldest Elephant.
    public Elephant getOldestElephant() {
        Elephant elephant = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            Elephant currentElephant = this.data.get(i);
            if (currentElephant.getAge() > elephant.getAge()) {
                elephant = currentElephant;
            }
        }
        return elephant;
    }

    //Getter getAllElephants() – returns the number of elephants.
    public int getAllElephants() {
        return this.data.size();
    }

    //getReport() – returns a String in the following format:
    //"Saved elephants in the park:
    //		 {name} came from: {retiredFrom}
    //          {name} came from: {retiredFrom}
    //          (…)"
    public String getReport() {
        StringBuilder result = new StringBuilder();
        result.append("Saved elephants in the park:");
        for (int i = 0; i < this.data.size(); i++) {
            result.append(System.lineSeparator());
            result.append(String.format("%s came from: %s", this.data.get(i).getName(), this.data.get(i).getRetiredFrom()));
        }
        return result.toString();
    }
}
