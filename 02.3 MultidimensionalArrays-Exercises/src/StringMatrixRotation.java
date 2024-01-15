
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static String degrees(String text) {
        Pattern pattern = Pattern.compile("^Rotate\\((?<int>[0-9]+)\\)$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            int result = Integer.parseInt(matcher.group("int"));
            result /= 90;
            result %= 4;
            return result + "";
        }
        return "";
    }

    public static void fixLength(List<String> list) {
        int maxLength = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxLength) {
                maxLength = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String currentElement = list.get(i);
            while (currentElement.length() < maxLength) {
                currentElement = String.format("%s ", currentElement);
            }
            list.set(i, currentElement);
        }
    }

    public static String[][] rotate1(String[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;
        List<String> buffer = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            String current = "";
            for (int j = matrix.length - 1; j >= 0; j--) {
                current = String.format("%s%s", current, matrix[j][i]);
            }
            buffer.add(current);
        }
        String[][] result = new String[row][col];
        for (int i = 0; i < buffer.size(); i++) {
            result[i] = buffer.get(i).split("");
        }
        return result;
    }

    public static String[][] rotate2(String[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<String> buffer = new ArrayList<>();
        for (int i = matrix.length - 1; i >= 0; i--) {
            String current = "";
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                current = String.format("%s%s", current, matrix[i][j]);
            }
            buffer.add(current);
        }
        String[][] result = new String[row][col];
        for (int i = 0; i < buffer.size(); i++) {
            result[i] = buffer.get(i).split("");
        }
        return result;
    }

    public static String[][] rotate3(String[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;
        List<String> buffer = new ArrayList<>();
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            String current = "";
            for (int j = 0; j < matrix.length; j++) {
                current = String.format("%s%s", current, matrix[j][i]);
            }
            buffer.add(current);
        }
        String[][] result = new String[row][col];
        for (int i = 0; i < buffer.size(); i++) {
            result[i] = buffer.get(i).split("");
        }
        return result;
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        List<String> matrixRows = new ArrayList<>();
        String line = input.nextLine();
        while (!line.equals("END")) {
            matrixRows.add(line);
            line = input.nextLine();
        }
        fixLength(matrixRows);
        String[][] matrix = new String[matrixRows.size()][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = matrixRows.get(i).split("");
        }
        String typeRotation = degrees(command);

        switch (typeRotation) {
            case "1":
                //rotation 90
                matrix = rotate1(matrix);
                break;
            case "2":
                //rotation 180
                matrix = rotate2(matrix);
                break;
            case "3":
                //rotation 270
                matrix = rotate3(matrix);
                break;
        }
        printMatrix(matrix);
    }
}
