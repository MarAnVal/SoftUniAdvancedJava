package Exam_23_October_2021.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    //roster : List<Person>
    private List<Person> roster;
    //name: String
    private String name;
    //capacity: int
    private int capacity;

    //constructor should receive the name and capacity,
    // also it should initialize the roster with a new instance of the collection.

    public Hotel(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    //Method add(Person person) - adds an entity to the roster if there is room for it
    public void add(Person person) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(person);
        }
    }

    //Method remove(String name) - removes a person by given name, if such exists, and returns boolean
    public boolean remove(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            Person person = this.roster.get(i);
            if (person.getName().equals(name)) {
                return this.roster.remove(person);
            }
        }
        return false;
    }

    //Method getPerson(String name, String hometown) – returns the people with the given
    // name and hometown or null if there is no such person.
    public Person getPerson(String name, String hometown) {
        for (int i = 0; i < this.roster.size(); i++) {
            Person current = this.roster.get(i);
            if (current.getName().equals(name) && current.getHometown().equals(hometown)) {
                return current;
            }
        }
        return null;
    }

    //Getter getCount() – returns the number of people.

    public int getCount() {
        return this.roster.size();
    }

    //getStatistics() – returns a String in the following format:
    //"The people in the hotel {name} are:
    //{Person1}
    //{Person2}
    //(…)"
    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("The people in the hotel %s are:", this.name));
        for (int i = 0; i < this.roster.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.roster.get(i));
        }
        return text.toString();
    }
}
