
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static List<String> horizontal(String[][] matrix){
        List<String> resultLonelyQ = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("q")){
                    buffer.add(i + " " + j);
                }
                if(buffer.size() > 1){
                    buffer.clear();
                    break;
                }
            }
            if(!buffer.isEmpty()){
                resultLonelyQ.addAll(buffer);
                buffer.clear();
            }
        }
        return resultLonelyQ;
    }
    public static List<String> vertical(String[][] matrix){
        List<String> resultLonelyQ = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[j][i].equals("q")){
                    buffer.add(j + " " + i);
                }
                if(buffer.size() > 1){
                    buffer.clear();
                    break;
                }
            }
            if(!buffer.isEmpty()){
                resultLonelyQ.addAll(buffer);
                buffer.clear();
            }
        }
        return resultLonelyQ;
    }

    public static List<String> leftDiagonal(String[][] matrix){
        List<String> resultLonelyQ = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        for (int count = 0; count < 8; count++) {
            for (int j = 0, i = count; j <= count; j++, i--) {
                if (matrix[i][j].equals("q")){
                    buffer.add(i + " " + j);
                }
                if(buffer.size() > 1){
                    buffer.clear();
                    break;
                }
            }
            if(!buffer.isEmpty()){
                resultLonelyQ.addAll(buffer);
                buffer.clear();
            }
        }
        for (int count = 6; count >= 0; count--) {
            for (int i = 7 , j = 7 - count; j < 8; i--, j++) {
                if (matrix[i][j].equals("q")){
                    buffer.add(i + " " + j);
                }
                if(buffer.size() > 1){
                    buffer.clear();
                    break;
                }
            }
            if(!buffer.isEmpty()){
                resultLonelyQ.addAll(buffer);
                buffer.clear();
            }
        }
        return resultLonelyQ;
    }

    public static List<String> rightDiagonal(String[][] matrix){
        List<String> resultLonelyQ = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        for (int count = 8; count > 0; count--) {
            for (int i = 0, j = 8 - count; j < 8; i++, j++) {
                if (matrix[i][j].equals("q")){
                    buffer.add(i + " " + j);
                }
                if(buffer.size() > 1){
                    buffer.clear();
                    break;
                }
            }
            if(!buffer.isEmpty()){
                resultLonelyQ.addAll(buffer);
                buffer.clear();
            }
        }

        for (int count = 7; count > 0; count--) {
            for (int i = 8 - count, j = 0; i < 8; i++, j++) {
                if (matrix[i][j].equals("q")){
                    buffer.add(i + " " + j);
                }
                if(buffer.size() > 1){
                    buffer.clear();
                    break;
                }
            }
            if(!buffer.isEmpty()){
                resultLonelyQ.addAll(buffer);
                buffer.clear();
            }
        }
        return resultLonelyQ;
    }
    public static String lastQ(List<String> horizontal, List<String> vertical,
                               List<String> leftDiagonal, List<String> rightDiagonal){
        for (String e : horizontal) {
              if (vertical.contains(e) && leftDiagonal.contains(e) && rightDiagonal.contains(e)){
                  return e;
              }
        }
        return "error";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] matrix = new String[8][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input.nextLine().split("\\s+");
        }
        List<String> horizontal = horizontal(matrix);
        List<String> vertical = vertical(matrix);
        List<String> leftDiagonal = leftDiagonal(matrix);
        List<String> rightDiagonal = rightDiagonal(matrix);
        System.out.println(lastQ(horizontal, vertical, leftDiagonal, rightDiagonal));
    }
}
