
import java.util.Scanner;

public class AllDiagonalsLeft {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] matrix = new String[8][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input.nextLine().split(" ");
        }


        for (int count = 0; count < 8; count++) {
            for (int j = 0, i = count; j <= count; j++, i--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int count = 6; count >= 0; count--) {
            for (int i = 7 , j = 7 - count; j < 8; i--, j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
