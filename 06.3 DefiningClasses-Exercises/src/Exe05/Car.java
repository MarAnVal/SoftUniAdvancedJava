package Exe05;

public class Car {
private String model;
private Engine engine;
private int weight;
private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = color;
    }


    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    @Override
    public String toString() {
        //V4-33:
        // Power: 140
        // Displacement: 28
        // Efficiency: B
        if (this.weight == -1){
            return String.format("%s:\n%s\nWeight: n/a\nColor: %s",
                    this.model, this.engine.toString(), this.color);
        } else{
        return String.format("%s:\n%s\nWeight: %s\nColor: %s",
                this.model, this.engine.toString(), this.weight, this.color);}
    }
}

