
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int[][] matrix = fillMatrix(dimensions);

        String command = input.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int commandI = Integer.parseInt(command.split("\\s+")[0]);
            int commandJ = Integer.parseInt(command.split("\\s+")[1]);
            int power = Integer.parseInt(command.split("\\s+")[2]);

            for (int i = commandI - power; i <= commandI + power; i++) {
                if (isValid(i, commandJ, matrix) && i != commandI) {
                   matrix = removeElement(i, commandJ, matrix);
                }
            }

            for (int j = commandJ + power; j >= commandJ - power; j--) {
                if (isValid(commandI, j, matrix)) {
                   matrix = removeElement(commandI, j, matrix);
                }
            }
            command = input.nextLine();
        }
        printMatrix(matrix);
    }

    public static int[][] fillMatrix(String dimensions) {
        int row = Integer.parseInt(dimensions.split("\\s+")[0]);
        int col = Integer.parseInt(dimensions.split("\\s+")[1]);
        int[][] matrix = new int[row][col];
        int element = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = element;
                element++;
            }
        }
        return matrix;
    }


    public static int[][] removeElement(int i, int j, int[][] matrix) {
        int newLength = matrix[i].length - 1;
        if (newLength > 0) {
            int[] newRow = new int[newLength];
            for (int l = 0, k = 0; l < matrix[i].length; l++) {
                if (l != j) {
                    newRow[k] = matrix[i][l];
                    k++;
                }
            }
            matrix[i] = newRow;
        } else {
            int[][] newMatrix = new int[matrix.length - 1][];
            for (int l = 0, k = 0; l < matrix.length; l++) {
                if (l != i) {
                    newMatrix[k] = matrix[l];
                    k++;
                }
            }
            matrix = newMatrix;
        }
        return matrix;
    }

    public static boolean isValid(int i, int j, int[][] matrix) {
        if (i > -1 && i < matrix.length) {
            return j > -1 && j < matrix[i].length;
        }
        return false;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] element : matrix) {
            for (int j = 0; j < element.length; j++) {
                if (j == element.length - 1) {
                    System.out.print(element[j]);
                } else {
                    System.out.print(element[j] + " ");
                }
            }
            System.out.println();
        }
    }
}