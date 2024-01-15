
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int colons = Integer.parseInt(dimensions.split("\\s+")[1]);
        String[][] matrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = input.nextLine().split("\\s+");
        }
        String replacement = input.nextLine();
        String startPoint = input.nextLine();
        int startI = Integer.parseInt(startPoint.split("\\s+")[0]);
        int startJ = Integer.parseInt(startPoint.split("\\s+")[1]);

        String startChar = matrix[startI][startJ];
        matrix = fillMatrix(startI, startJ, matrix, startChar, replacement);

        printMatrix(matrix);

    }

    public static boolean isValid(int i, int j, int rows, int colons) {
        return i >= 0 && i < rows && j >= 0 && j < colons;
    }

    public static boolean isValidCell(int i, int j, String startChar, String[][] matrix) {
        return isValid(i, j, matrix.length, matrix[0].length) && matrix[i][j].equals(startChar);
    }

    public static String[][] fillMatrix(int i, int j, String[][] matrix, String startChar, String replacement) {
        if (isValidCell(i, j, startChar, matrix)) {
            matrix[i][j] = replacement;
            if (isValidCell(i + 1, j, startChar, matrix)) {
                matrix = fillMatrix(i + 1, j, matrix, startChar, replacement);
            }
            if (isValidCell(i - 1, j, startChar, matrix)) {
                matrix = fillMatrix(i - 1, j, matrix, startChar, replacement);
            }
            if (isValidCell(i, j + 1, startChar, matrix)) {
                matrix = fillMatrix(i, j + 1, matrix, startChar, replacement);
            }
            if (isValidCell(i, j - 1, startChar, matrix)) {
                matrix = fillMatrix(i, j - 1, matrix, startChar, replacement);
            }
        }
        return matrix;
    }
    public static void printMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.join("", matrix[i]));
        }
    }
}
