package Exe03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String model = line.split("\\s+")[0];
            double fuel = Double.parseDouble(line.split("\\s+")[1]);
            double costPerKm = Double.parseDouble(line.split("\\s+")[2]);
            Car car = new Car(model, fuel, costPerKm);
            carsMap.put(model, car);
        }
        String command = input.nextLine();
        while (!command.equals("End")) {
            String carModelToDrive = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);
            Car carToDrive = carsMap.get(carModelToDrive);
            String result = carToDrive.drive(kmToDrive);
            if (!result.equals("drive")) {
                System.out.println(result);
            }
            command = input.nextLine();
        }
        for (Map.Entry<String, Car> entry : carsMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }

    }
}
