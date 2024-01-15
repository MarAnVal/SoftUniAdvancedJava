import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //97+i+j :middle char
        //97+i :first and last char
        String line = input.nextLine();
        String[][] matrix =new String [Integer.parseInt(line.split("\\s+")[0])]
                [Integer.parseInt(line.split("\\s+")[1])];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char firstLast = (char) (97 + i);
                char middle = (char) (97 + i + j);
                System.out.printf("%c%c%c ", firstLast, middle, firstLast);
            }
            System.out.println();
        }
    }
}
