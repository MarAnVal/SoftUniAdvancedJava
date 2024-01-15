package Lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            if (line.length > 1) {
                Car newCar = new Car(line[0], line[1], Integer.parseInt(line[2]));
                cars.add(newCar);
            } else {
                Car newCar = new Car(line[0]);
                cars.add(newCar);
            }

        }
        cars.forEach(e -> System.out.println(e.toString()));
    }
}
