import java.util.Scanner;

public class AllHorizontal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] matrix = new String[8][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input.nextLine().split(" ");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
