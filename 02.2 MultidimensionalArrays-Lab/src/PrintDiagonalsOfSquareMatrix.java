
import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = Integer.parseInt(input.nextLine());
        int [][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = matrix.length - 1; i >= 0; i--) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
    }
}
