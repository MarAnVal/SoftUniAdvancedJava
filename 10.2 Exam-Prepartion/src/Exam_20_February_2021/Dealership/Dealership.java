package Exam_20_February_2021.Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //data (Collection, which stores the entity Car)
    private List<Car> data;
    //name: String
    private String name;
    //capacity: int
    private int capacity;

    //constructor should receive the name and capacity,
    // also it should initialize the data with a new instance of the collection

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    //Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    //Method buy(String manufacturer, String model) – removes the car by given manufacturer
    // and model, if such exists, and returns boolean.
    public boolean buy(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            Car current = this.data.get(i);
            if (current.getManufacturer().equals(manufacturer) && current.getModel().equals(model)) {
                return this.data.remove(current);
            }
        }
        return false;
    }

    //Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar() {
        if (!this.data.isEmpty()) {
            Car car = this.data.get(0);
            for (int i = 0; i < this.data.size(); i++) {
                Car current = this.data.get(i);
                if (current.getYear() > car.getYear()) {
                    car = current;
                }
            }
            return car;
        }
        return null;
    }

    //Method getCar(String manufacturer, String model) – returns the car with the
    // given manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            Car current = this.data.get(i);
            if (current.getManufacturer().equals(manufacturer) && current.getModel().equals(model)) {
                return current;
            }
        }
        return null;
    }

    //Getter getCount() – returns the number of cars.
    public int getCount() {
        return this.data.size();
    }
    //getStatistics() – returns a String in the following format:
    //" The cars are in a car dealership {name}:
    //{Car1}
    //{Car2}
    //(…)"
    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append(String.format(" The cars are in a car dealership %s:", this.name));
        for (int i = 0; i < this.data.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.data.get(i));
        }
        return text.toString();
    }
}
