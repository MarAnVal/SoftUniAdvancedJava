import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (number == 0) {
            binary.push(0);
        } else {
            while (number > 0) {
                int bite = number % 2;
                binary.push(bite);
                number /= 2;
            }
        }
        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
    }
}
