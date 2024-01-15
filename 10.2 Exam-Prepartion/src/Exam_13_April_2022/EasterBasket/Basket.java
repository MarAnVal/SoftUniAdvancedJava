package Exam_13_April_2022.EasterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    //material: String
    //capacity: int
    //List<Egg> data - collection that holds added eggs
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }
    }

    //Method removeEgg(string color) – removes an egg by given color, if such exists,
    // and returns boolean (true if it is removed, otherwise – false)
    public boolean removeEgg(String color) {
        for (int i = 0; i < this.data.size(); i++) {
            Egg egg = this.data.get(i);
            if (egg.getColor().equals(color)) {
                return this.data.remove(egg);
            }
        }
        return false;
    }

    //Method getStrongestEgg()– returns the strongest egg
    public Egg getStrongestEgg() {
        Egg egg = null;
        if (this.data.size() > 0) {
            egg = this.data.get(0);
            for (int i = 1; i < this.data.size(); i++) {
                Egg current = this.data.get(i);
                if (current.getStrength() > egg.getStrength()) {
                    egg = current;
                }
            }
        }
        return egg;
    }

    //Method getEgg(string color) – returns the egg with the given color
    public Egg getEgg(String color) {
        for (int i = 0; i < this.data.size(); i++) {
            Egg egg = this.data.get(i);
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    //Method getCount – returns the number of eggs
    public int getCount(){
        return this.data.size();
    }

    //Method report() – returns a string in the following format
    // (print the eggs in order of appearance):
    //"{material} basket contains:
    //{Egg1}
    //{Egg2}
    //(…)"
    public String report(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("%s basket contains:", this.material));
        for (int i = 0; i < this.data.size(); i++) {
          text.append(System.lineSeparator());
          text.append(this.data.get(i).toString());
        }
        return text.toString();
    }
}
