import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String names = input.nextLine();
        int turns = Integer.parseInt(input.nextLine());
        PriorityQueue<String> queue = new PriorityQueue<>();

        Collections.addAll(queue, names.split("\\s+"));
        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < turns; i++) {
                String name = queue.poll();
                queue.offer(name);
            }
            if (!isPrime(cycle)) {
                System.out.printf("Removed %s%n", queue.poll());
            } else {
                System.out.printf("Prime %s%n", queue.peek());
            }
            cycle++;
        }
        System.out.printf("Last is %s%n", queue.poll());


    }
}
