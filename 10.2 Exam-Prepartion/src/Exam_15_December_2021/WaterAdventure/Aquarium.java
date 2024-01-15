package Exam_15_December_2021.WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    //fishInPool: List<Fish>
    private List<Fish> fishInPool;
    //name: String
    private String name;
    //capacity: int
    private int capacity;
    //size: int - the volume of the pool
    private int size;

    // constructor of the Aquarium class should receive the name, capacity, and size,
    // also you should initialize the collection of fish with a new instance.
    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    //Getter getName().
    public String getName() {
        return name;
    }

    //Getter getCapacity().
    public int getCapacity() {
        return capacity;
    }

    //Getter getSize().
    public int getSize() {
        return size;
    }

    //Getter getFishInPool() - returns the number of fish in the current pool.
    public int getFishInPool() {
        return fishInPool.size();
    }

    //Method add(Fish fish) - add the entity if there isn't a fish
    // with the same name and if there is enough space for it.
    public void add(Fish fish) {
        if (this.capacity > this.fishInPool.size()) {
            boolean noSuchFich = true;
            for (int i = 0; i < this.fishInPool.size(); i++) {
                Fish current = this.fishInPool.get(i);
                if (current.getName().equals(fish.getName())) {
                    noSuchFich = false;
                    break;
                }
            }
            if (noSuchFich) {
                this.fishInPool.add(fish);
            }
        }
    }

    //Method remove(String name) - removes a fish from the pool with
    // the given name, if such exists, and returns a boolean if the deletion is successful.
    public boolean remove(String name) {
        for (int i = 0; i < this.fishInPool.size(); i++) {
            Fish current = this.fishInPool.get(i);
            if (current.getName().equals(name)) {
                return this.fishInPool.remove(current);
            }
        }
        return false;
    }

    //Method findFish(String name) - returns a fish with the given name, it doesn't exist return null.
    public Fish findFish(String name) {
        for (int i = 0; i < this.fishInPool.size(); i++) {
            Fish current = this.fishInPool.get(i);
            if (current.getName().equals(name)){
                return current;
            }
        }
        return null;
    }
    //Method report() - returns information about the aquarium and the fish inside it in the following format:
    //"Aquarium: {name} ^ Size: {size}
    //{Fish1}
    //{Fish2}
    //…"
    public String report(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size));
        for (int i = 0; i < this.fishInPool.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.fishInPool.get(i).toString());
        }
        return text.toString();
    }
}
