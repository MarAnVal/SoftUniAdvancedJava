
import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split(",\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split(",\\s+")[1]);
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
