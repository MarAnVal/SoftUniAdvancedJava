
import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int row = Integer.parseInt(line.split("\\s+")[0]);
        int col = Integer.parseInt(line.split("\\s+")[1]);
        int[][] matrix = new int[row][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currentSum = 0;
                int element = matrix[i][j];
                if (i == 0 && j == 0) {
                    sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                            matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                            matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                } else {
                    currentSum += matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                            matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                            matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                }
                if (currentSum > sum) {
                    sum = currentSum;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Sum = " + sum);
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
