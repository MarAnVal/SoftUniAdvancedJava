package Exam_26_June_2021.GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    //data : List<Pet>
    private List<Pet> date;
    //capacity: int
    private int capacity;

    //constructor should receive capacity, also it should
    // initialize the data with a new instance of the collection

    public GroomingSalon(int capacity) {
        this.date = new ArrayList<>();
        this.capacity = capacity;
    }

    //Method add(Pet pet) – adds an entity to the data if there
    // is an empty place in the grooming salon for the pet.
    public void add(Pet pet) {
        if (this.capacity > this.date.size()) {
            this.date.add(pet);
        }
    }

    //Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (int i = 0; i < this.date.size(); i++) {
            Pet pet = this.date.get(i);
            if (pet.getName().equals(name)) {
                return this.date.remove(pet);
            }
        }
        return false;
    }

    //Method getPet(String name, String owner) – returns the pet with the given
    // name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner) {
        for (int i = 0; i < this.date.size(); i++) {
            Pet pet = this.date.get(i);
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    //Getter getCount – returns the number of pets.

    public int getCount() {
        return this.date.size();
    }

    //getStatistics() – returns a String in the following format:
    //" The grooming salon has the following clients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"
    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append(" The grooming salon has the following clients:");
        for (int i = 0; i < this.date.size(); i++) {
            Pet pet = this.date.get(i);
            text.append(System.lineSeparator());
            text.append(String.format("%s %s", pet.getName(), pet.getOwner()));
        }
        return text.toString();
    }
}
