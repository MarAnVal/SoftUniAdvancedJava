package Exam_19_February_2022.Parrots;

public class Parrot {
    //name: String
    private String name;
    //species: String
    private String species;
    //available: boolean - true by default
    private boolean available;

    //The class constructor should receive (name, species).

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    //getName()
    public String getName() {
        return name;
    }

    //getSpecies()
    public String getSpecies() {
        return species;
    }

    //isAvailable()
    public boolean isAvailable() {
        return available;
    }

    //setAvailable()
    public void setAvailable(boolean available) {
        this.available = available;
    }

    //Override the toString() method in the format:
    //"Parrot ({species}): {name}"
    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", this.species, this.name);
    }
}
