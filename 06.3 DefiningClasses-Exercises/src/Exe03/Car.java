package Exe03;

public class Car {
    private String model;
    private double fuelAmount;
    private double costPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double costPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costPerKm = costPerKm;
        this.distanceTraveled = 0;
    }

    public boolean isAbleDrive(int kmDrive) {
        double neededFuel = kmDrive * this.costPerKm;
        if (neededFuel <= this.fuelAmount) {
            return true;
        } else return false;
    }

    public String drive(int kmDrive) {
        String result = "Insufficient fuel for the drive";
        if (this.isAbleDrive(kmDrive)) {
            this.fuelAmount -= kmDrive * this.costPerKm;
            this.distanceTraveled += kmDrive;
            result = "drive";
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
