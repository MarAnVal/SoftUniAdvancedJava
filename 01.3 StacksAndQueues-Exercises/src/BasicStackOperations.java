import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int s = input.nextInt();
        int x = input.nextInt();
        ArrayDeque <Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbers.push(input.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numbers.pop();
        }
        if (numbers.contains(x)){
            System.out.println("true");
        } else if (!numbers.isEmpty()){
            System.out.println(Collections.min(numbers));
        } else {
            System.out.println(0);
        }

    }
}
