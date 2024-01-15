import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int n = Integer.parseInt(line.split(",\\s+")[0]);
        String pattern = line.split(",\\s+")[1];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(pattern.equals("A")){
                    matrix[i][j] = (i + 1) + j * n;
                } else if (pattern.equals("B")){
                    if ((j+3) % 2 != 0){
                        matrix[i][j] = (i + 1) + j * n;
                    } else {
                        matrix[i][j] = (j + 1)* n - i;
                    }
                }
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
