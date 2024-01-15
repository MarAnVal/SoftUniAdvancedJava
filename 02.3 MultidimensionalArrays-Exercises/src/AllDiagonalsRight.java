import java.util.Scanner;

public class AllDiagonalsRight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] matrix = new String[8][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input.nextLine().split(" ");
        }


        for (int count = 8; count > 0; count--) {
            for (int i = 0, j = 8 - count; j < 8; i++, j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int count = 7; count > 0; count--) {
            for (int i = 8 - count, j = 0; i < 8; i++, j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
