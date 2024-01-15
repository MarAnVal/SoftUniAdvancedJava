package Lab01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            Car car = new Car(line.split("\\s+")[0], line.split("\\s+")[1], Integer.parseInt(line.split("\\s+")[2]));
            cars.add(car);


        }
        cars.forEach(e -> System.out.println(e.toString()));
    }
}

