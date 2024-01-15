package Exam_28_June_2020.Parking;

public class Car {
    //manufacturer: String
    private String manufacturer;
    //model: String
    private String model;
    //year: int
    private int year;

    //constructor should receive the manufacturer, model, and year

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    //toString() method in the following format:
    //"{manufacturer} {model} ({year})"
    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.manufacturer, this.model, this.year);
    }
}
