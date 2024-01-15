
import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int firstSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            firstSum += matrix[i][i];
        }
        int secondSum = 0;
        for (int i = matrix.length - 1, j = 0; i >= 0;  i--, j++) {
            secondSum += matrix[i][j];
        }
        System.out.println(Math.abs(firstSum - secondSum));

    }
}
