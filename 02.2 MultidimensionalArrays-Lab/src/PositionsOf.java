
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int rows = Integer.parseInt(line.split("\\s+")[0]);
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            line = input.nextLine();
            matrix[i] = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        line = input.nextLine();
        int number = Integer.parseInt(line);
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
