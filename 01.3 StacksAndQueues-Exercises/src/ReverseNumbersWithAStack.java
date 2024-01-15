import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
        String[] line = input.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++) {
            numbers.push(line[i]);
        }
        while (!numbers.isEmpty()) {
            System.out.printf("%s ",numbers.pop());
        }
        System.out.println();
    }
}
