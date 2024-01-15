import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int addCount = input.nextInt();
        int removeCount = input.nextInt();
        int neededNum = input.nextInt();
        ArrayDeque <Integer> elements = new ArrayDeque<>();

        for (int i = 0; i < addCount; i++) {
            elements.offer(input.nextInt());
        }
        for (int i = 0; i < removeCount; i++) {
            elements.poll();
        }
        if (elements.contains(neededNum)){
            System.out.println("true");
        } else {
            if (elements.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(elements));
            }
        }
    }
}
