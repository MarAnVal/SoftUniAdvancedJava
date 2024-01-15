package Exe07;

public class Car {
    //"{Name} car {carModel} {carSpeed}"
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        if (model.length() > 0) {
            return String.format("%n%s %s", this.model, this.speed);
        } else return "";
    }
}
