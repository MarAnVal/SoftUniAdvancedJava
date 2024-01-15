package Exam_17_Dec_2019.Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.data = new ArrayList<>();
        this.color = color;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getColor() {
        return this.color;
    }
    public int count(){
        return this.data.size();
    }
    public void add(Present present){
        if (this.capacity > this.data.size()){
            this.data.add(present);
        }
    }
    public boolean remove (String name){
        for (int i = 0; i < this.data.size(); i++) {
            Present present = this.data.get(i);
            if(present.getName().equals(name)){
                return this.data.remove(present);
            }
        }
        return false;
    }
    public Present heaviestPresent(){
        Present present = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            Present current = this.data.get(i);
            if (current.getWeight() > present.getWeight()){
                present = current;
            }
        }
        return present;
    }
    public Present getPresent(String name){
        for (int i = 0; i < this.data.size(); i++) {
            Present present = this.data.get(i);
            if(present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }
    public String report(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("%s bag contains:", this.color));
        for (int i = 0; i < this.data.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.data.get(i));
        }
        return text.toString();
    }
}
