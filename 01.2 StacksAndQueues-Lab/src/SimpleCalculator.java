import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ArrayDeque<String> elements = new ArrayDeque<>();
        Collections.addAll(elements, line.split("\\s+"));
        int sum = 0;
        while (!elements.isEmpty()) {
            String element = elements.pop();
            switch (element) {
                case "+":
                    sum += Integer.parseInt(elements.pop());
                    break;
                case "-":
                    sum -= Integer.parseInt(elements.pop());
                    break;
                default:
                    sum += Integer.parseInt(element);
                    break;
            }
        }
        System.out.println(sum);
    }
}
