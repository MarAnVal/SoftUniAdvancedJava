import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ArrayDeque<String> orders = new ArrayDeque<>();

        while (!line.equals("print")) {
            if (line.equals("cancel")) {
                if (orders.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", orders.poll());
                }
            } else {
                orders.offer(line);
            }

            line = input.nextLine();
        }
        while (!orders.isEmpty()) {
            System.out.println(orders.pop());
        }
    }
}
