
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int row = Integer.parseInt(dimensions.split("\\s+")[0]);
        int col = Integer.parseInt(dimensions.split("\\s+")[1]);
        String[][] matrix = new String[row][];
        for (int i = 0; i < row; i++) {
            matrix[i] = input.nextLine().split("\\s+");
        }
        String command = input.nextLine();
        while (!command.equals("END")) {
            boolean isValid = false;
            Pattern pattern = Pattern.compile("^(?<command>swap)\\s(?<i>\\d+)\\s(?<j>\\d+)\\s(?<newi>\\d+)\\s(?<newj>\\d+)$");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int firstRow = Integer.parseInt(matcher.group("i"));
                int firstCol = Integer.parseInt(matcher.group("j"));
                int secondRow = Integer.parseInt(matcher.group("newi"));
                int secondCol = Integer.parseInt(matcher.group("newj"));
                if (firstRow <= row && firstCol <= col && secondRow <= row && secondCol <= col) {
                    String buffer = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = buffer;
                    isValid = true;
                }
            }
            if (isValid) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = input.nextLine();
        }
    }
}
