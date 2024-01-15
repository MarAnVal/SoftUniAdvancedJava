package Exam_28_June_2020.Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    //Field data – Collection that holds added cars
    private List<Car> data;
    //type: String
    private String type;
    //capacity: int
    private int capacity;

    //constructor should receive type and capacity,
    // also it should initialize the data with a new instance of the collection

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    //Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    //Method remove(String manufacturer, String model) – removes the car by given
    // manufacturer and model, if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            Car car = this.data.get(i);
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return this.data.remove(car);
            }
        }
        return false;
    }

    //Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar() {
        Car car = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            Car current = this.data.get(i);
            if (car.getYear() < current.getYear()) {
                car = current;
            }
        }
        return car;
    }

    //Method getCar(String manufacturer, String model) – returns the car with
    // the given manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            Car car = this.data.get(i);
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    //Getter getCount() – returns the number of cars.
    public int getCount() {
        return this.data.size();
    }
    //getStatistics() – returns a String in the following format:
    //"The cars are parked in {parking type}:
    //{Car1}
    //{Car2}
    //(…)"
    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("The cars are parked in %s:", this.type));
        for (int i = 0; i < this.data.size(); i++) {
            Car car = this.data.get(i);
            text.append(System.lineSeparator());
            text.append(car);
        }
        return text.toString();
    }
}
