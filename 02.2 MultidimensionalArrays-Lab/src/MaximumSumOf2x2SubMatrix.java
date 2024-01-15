
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split(",\\s+")[0]);
        int [][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = 0;
        int rowIndex = 0;
        int colIndex = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (i == 0 && j == 0){
                    maxSum = matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] + matrix[i+1][j+1];
                } else {
                    int currentSum = matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] + matrix[i+1][j+1];
                    if (maxSum < currentSum){
                        maxSum = currentSum;
                        rowIndex = i;
                        colIndex = j;
                    }
                }
            }
        }
        System.out.println(matrix[rowIndex][colIndex]+ " " + matrix[rowIndex][colIndex + 1]);
        System.out.println(matrix[rowIndex + 1][colIndex] + " " + matrix[rowIndex + 1][colIndex + 1]);
        System.out.println(maxSum);
    }
}
