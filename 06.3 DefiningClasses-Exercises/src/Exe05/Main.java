package Exe05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Engine> enginesMap = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        int enginesCount = Integer.parseInt(input.nextLine());
        for (int i = 0; i < enginesCount; i++) {
            String[] line = input.nextLine().split("\\s+");
            String engineModel = line[0];
            String enginePower = line[1];
            if (line.length == 4) {
                int engineDisplacement = Integer.parseInt(line[2]);
                String engineEfficiency = line[3];
                enginesMap.put(engineModel, new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency));
            } else if (line.length == 2) {
                enginesMap.put(engineModel, new Engine(engineModel, enginePower));
            } else if (line.length == 3) {
                String text = line[2];
                if (isItDigit(text)) {
                    enginesMap.put(engineModel, new Engine(engineModel, enginePower, Integer.parseInt(text)));
                } else {
                    enginesMap.put(engineModel, new Engine(engineModel, enginePower, text));
                }
            }

        }
        int carCount = Integer.parseInt(input.nextLine());
        for (int j = 0; j < carCount; j++) {
            String[] line = input.nextLine().split("\\s+");
            String carModel = line[0];
            String engineModel = line[1];
            Engine engine = enginesMap.get(engineModel);
            Car car = null;
            if (line.length == 4) {
                int carWeight = Integer.parseInt(line[2]);
                String carColor = line[3];
                car = new Car(carModel, engine, carWeight, carColor);
            } else if (line.length == 2) {
                car = new Car(carModel, engine);
            } else if (line.length == 3) {
                String text = line[2];
                if (isItDigit(text)) {
                    car = new Car(carModel, engine, Integer.parseInt(text));
                } else {
                    car = new Car(carModel, engine, text);
                }
            }
            cars.add(car);
        }
        cars.forEach(e -> System.out.println(e));
    }

    public static boolean isItDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}

