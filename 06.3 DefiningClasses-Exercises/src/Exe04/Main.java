package Exe04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age}
            // {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}"
            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tireList = new ArrayList<>();
            int tireIndex = 0;
            for (int j = 5; j < line.length; j += 2) {
                double pressure = Double.parseDouble(line[j]);
                int age = Integer.parseInt(line[j + 1]);
                if (pressure < 1) {
                    tireIndex++;
                }
                tireList.add(new Tire(pressure, age));
            }
            Tires tires = new Tires(tireList.get(0), tireList.get(1), tireList.get(2), tireList.get(3), tireIndex);

            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }
        String command = input.nextLine();
        switch (command){
            case "fragile":
                //print all cars whose Cargo Type is "fragile" with a tire whose pressure is < 1
                for (Car car: carList) {
                    if(car.getCargo().getType().equals(command) && car.getTires().getIndexTires() > 0){
                        System.out.println(car.getModel());
                    }
                }
                break;
            case "flamable":
                //print all cars whose Cargo Type is "flamable" and have Engine Power > 250
                for (Car car: carList) {
                    if(car.getCargo().getType().equals(command) && car.getEngine().getPower() > 250){
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }
}
