package Exe05;

public class Engine {
    private String model;
    private String power;// мощност
    private int displacement;//работен обем
    private String efficiency; //ефективност

    public Engine(String model, String power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, String power, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    @Override
    public String toString() {
        //V4-33:
        // Power: 140
        // Displacement: 28
        // Efficiency: B
        if(this.displacement == -1){
            return String.format("%s:\nPower: %s\nDisplacement: n/a\nEfficiency: %s",
                    this.model, this.power, this.efficiency);
        }else{
        return String.format("%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s",
                this.model, this.power, this.displacement, this.efficiency);}
    }
}
