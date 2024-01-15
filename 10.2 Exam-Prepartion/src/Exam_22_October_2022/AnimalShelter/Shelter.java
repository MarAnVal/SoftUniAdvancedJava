package Exam_22_October_2022.AnimalShelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    //class Shelter that has data (a List, which stores the Animals).
    //All entities inside the repository have the same fields.
    //Also, the Shelter class should have those fields:
    //capacity: int
    private List<Animal> data;
    private int capacity;

    //The class constructor should receive capacity,
    //also it should initialize the data with a new instance of the collection.

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //Method add(Animal animal) – adds an entity to the data if there is an empty cell for the animal.
    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    //Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                Animal animal = this.data.get(i);
                return this.data.remove(animal);

            }
        }
        return false;
    }

    //Method getAnimal(String name, String caretaker) – returns the animal with the given
    // name and caretaker or null if no such animal exists.
    public Animal getAnimal(String name, String caretaker) {
        Animal animal = null;
        for (int i = 0; i < this.data.size(); i++) {
            Animal currentAnimal = this.data.get(i);
            if (currentAnimal.getName().equals(name) && currentAnimal.getCaretaker().equals(caretaker)) {
                animal = currentAnimal;
            }
        }
        return animal;
    }

    //Method getOldestAnimal() – returns the oldest Animal.
    public Animal getOldestAnimal() {
        Animal oldest = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            if (oldest.getAge() <= this.data.get(i).getAge()) {
                oldest = this.data.get(i);
            }
        }
        return oldest;
    }

    //Getter getCount – returns the number of animals.
    public int getCount() {
        return this.data.size();
    }

    //getStatistics() – returns a String in the following format:
    //"The shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}
    //   (…)"
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("The shelter has the following animals:");
        for (int i = 0; i < this.data.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.data.get(i).getName());
            text.append(" ");
            text.append(this.data.get(i).getCaretaker());
        }
        return text.toString();
    }
}
