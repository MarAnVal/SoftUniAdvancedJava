package Exe04;

public class Tires {
    //{Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}
private Tire tire1;
private Tire tire2;
private Tire tire3;
private Tire tire4;
private int indexTires;

    public Tires(Tire tire1, Tire tire2, Tire tire3, Tire tire4, int indexTires) {
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
        this.indexTires = indexTires;
    }

    public int getIndexTires() {
        return indexTires;
    }
}
