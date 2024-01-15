
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static List<String> allWrongElementsDimensions(int[][] matrix, String firstDimensions) {
        int wrongNum = matrix[Integer.parseInt(firstDimensions.split("\\s+")[0])]
                [Integer.parseInt(firstDimensions.split("\\s+")[1])];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNum) {
                    result.add(i + " " + j);
                }
            }
        }
        return result;
    }

    public static void fixElements(int[][] matrix, List<String> allWrongElements) {
        for (int list = 0; list < allWrongElements.size(); list++) {
            int i = Integer.parseInt(allWrongElements.get(list).split("\\s+")[0]);
            int j = Integer.parseInt(allWrongElements.get(list).split("\\s+")[1]);
            int sum = 0;
            if (i + 1 < matrix.length) {
                int k = i + 1;
                if(!allWrongElements.contains(k + " " + j)){
                sum += matrix[i + 1][j];
                }

            }
            if (i - 1 > -1) {
                int k = i - 1;
                if (!allWrongElements.contains(k + " " + j)){
                sum += matrix[i - 1][j];
                }
            }
            if (j + 1 < matrix[i].length) {
                int k = j + 1;
                if (!allWrongElements.contains(i + " " + k)){
                sum += matrix[i][j + 1];
                }
            }
            if (j - 1 > -1) {
                int k = j - 1;
                if(!allWrongElements.contains(i + " " + k)){
                sum += matrix[i][j - 1];
                }
            }
            matrix[i][j] = sum;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        String firstDimensions = input.nextLine();
        List<String> allWrongElements = allWrongElementsDimensions(matrix, firstDimensions);
        fixElements(matrix, allWrongElements);
        printMatrix(matrix);
    }
}
