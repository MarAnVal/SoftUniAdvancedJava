
import java.util.Arrays;
import java.util.Scanner;


public class CompareMatrices {


    public static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length) {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[i].length; j++) {
                    if (firstMatrix[i][j] != secondMatrix[i][j]) {
                        return false;
                    }
                }
            }
        } else return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int[][] firstMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            dimensions = input.nextLine();
            firstMatrix[i] = Arrays.stream(dimensions.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        dimensions = input.nextLine();
        rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int[][] secondMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            dimensions = input.nextLine();
            secondMatrix[i] = Arrays.stream(dimensions.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
