import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String names = input.nextLine();
        int turns = Integer.parseInt(input.nextLine());
        ArrayDeque <String> queue = new ArrayDeque<>();

        Collections.addAll(queue, names.split("\\s+"));

        while (queue.size() > 1){
            for (int i = 1; i < turns; i++) {
                String name = queue.poll();
                queue.offer(name);
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s%n", queue.poll());
    }
}
