package Exe04;

public class Cargo {
    //{CargoWeight} {CargoType}
    //weight is integer
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
