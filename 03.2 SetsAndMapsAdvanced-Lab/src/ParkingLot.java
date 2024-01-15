import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashSet<String> cars = new LinkedHashSet<>();
        String line = input.nextLine();
        while (!line.equals("END")) {
            String direction = line.split(",\\s+")[0];
            String carID = line.split(",\\s+")[1];
            switch (direction){
                case "IN":
                    cars.add(carID);
                    break;
                case "OUT":
                    cars.remove(carID);
                    break;
            }
            line = input.nextLine();
        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(e -> System.out.println(e));
        }
    }
}
