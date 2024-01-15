
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int colons = Integer.parseInt(dimensions.split("\\s+")[1]);
        boolean[][] lot = new boolean[rows][colons];
        for (int i = 0; i < rows; i++) {
            lot[i][0] = true;
        }
        String car = input.nextLine();
        while (!car.equals("stop")) {
            int startI = Integer.parseInt(car.split("\\s+")[0]);
            int endI = Integer.parseInt(car.split("\\s+")[1]);
            int wishedJ = Integer.parseInt(car.split("\\s+")[2]);
            if (!lot[endI][wishedJ]) {
                lot[endI][wishedJ] = true;
                System.out.println(Math.abs(startI - endI) + wishedJ + 1);
            } else {
                for (int k = 1; k < colons; k++) {
                    if (isValidCell(endI, wishedJ - k, lot)) {
                        wishedJ = wishedJ - k;
                        lot[endI][wishedJ] = true;
                        System.out.println(Math.abs(startI - endI) + wishedJ + 1);
                        break;
                    } else if (isValidCell(endI, wishedJ + k, lot)) {
                        wishedJ = wishedJ + k;
                        lot[endI][wishedJ] = true;
                        System.out.println(Math.abs(startI - endI) + wishedJ + 1);
                        break;
                    } else if (!isValidColon(wishedJ + k, colons) && !isValidColon(wishedJ - k, colons)) {
                        System.out.printf("Row %d full%n", endI);
                        break;
                    }
                }
            }
            car = input.nextLine();
        }
    }

    public static boolean isValidColon(int j, int colons) {
        return j > 0 && j < colons;
    }

    public static boolean isValidCell(int i, int j, boolean[][] lot) {
        if (isValidColon(j, lot[i].length)) {
            return !lot[i][j];
        } else return false;
    }
}
