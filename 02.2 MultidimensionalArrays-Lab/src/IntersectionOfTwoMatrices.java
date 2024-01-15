import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = Integer.parseInt(input.nextLine());
        int cols = Integer.parseInt(input.nextLine());
        String [][] firstMatrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            firstMatrix[i] = input.nextLine().split("\\s+");
        }
        String[][] secondMatrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            secondMatrix[i] = input.nextLine().split("\\s+");
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])){
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
