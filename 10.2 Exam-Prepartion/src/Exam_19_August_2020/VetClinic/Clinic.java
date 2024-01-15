package Exam_19_August_2020.VetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    //data – List that holds added pets
    private List<Pet> data;
    //capacity: int
    private int capacity;

    //constructor should receive capacity, also it should initialize the data with a new instance of the collection

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    //Method add(Pet pet) – adds an entity to the data if there is an empty cell for the pet.
    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    //Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            Pet pet = this.data.get(i);
            if (pet.getName().equals(name)) {
                return this.data.remove(pet);
            }
        }
        return false;
    }

    //Method getPet(String name, String owner) – returns the pet with the given
    // name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner) {
        for (int i = 0; i < this.data.size(); i++) {
            Pet pet = this.data.get(i);
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    //Method getOldestPet() – returns the oldest Pet.
    public Pet getOldestPet() {
        if (!this.data.isEmpty()) {
            Pet pet = this.data.get(0);
            for (int i = 1; i < this.data.size(); i++) {
                Pet current = this.data.get(i);
                if (current.getAge() > pet.getAge()) {
                    pet = current;
                }
            }
            return pet;
        }
        return null;
    }

    //Getter getCount – returns the number of pets.
    public int getCount() {
        return this.data.size();
    }
    //getStatistics() – returns a String in the following format:
    //"The clinic has the following patients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"
    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append("The clinic has the following patients:");
        for (int i = 0; i < this.data.size(); i++) {
            Pet pet = this.data.get(i);
            text.append(System.lineSeparator());
            text.append(String.format("%s %s", pet.getName(), pet.getOwner()));
        }
        return text.toString();
    }
}
