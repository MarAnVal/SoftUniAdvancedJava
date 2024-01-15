package Exe04;

public class Car {
    //"{Model} {Engine} {Cargo} {Tires}
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }
}
