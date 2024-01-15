
import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int colons = Integer.parseInt(dimensions.split("\\s+")[1]);
        int [][] matrix = new int[rows][colons];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        printDiagonalsStartBottomRight(rows,colons,matrix);
    }
    public static void printDiagonalsStartBottomRight(int rows, int colons, int[][] matrix){
        for (int count = colons - 1; count >=  0; count--) {
            for (int i = rows - 1, j = count; i >= 0 && j < colons; i--, j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int count = rows - 2; count >= 0; count--) {
            for (int i = count, j = 0; i >= 0 && j < colons; i--, j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
