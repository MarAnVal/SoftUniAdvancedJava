import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] line = input.nextLine().split("\\s+");
        ArrayDeque<Integer> plantsStack = new ArrayDeque<>();
        for (int i = 0; i < line.length; i++) {
            plantsStack.push(Integer.parseInt(line[i]));
        }
        int days = 0;
        boolean flag = true;
        while (flag) {
            ArrayDeque<Integer> bufferStack = new ArrayDeque<>();
            while (!plantsStack.isEmpty()) {
                int currentPlant = plantsStack.pop();
                if (plantsStack.isEmpty()) {
                    bufferStack.push(currentPlant);
                } else {
                    if (currentPlant <= plantsStack.peek()) {
                        bufferStack.push(currentPlant);
                    }
                }
            }
            if (bufferStack.size() < n) {
                n = bufferStack.size();
                days++;
                while (!bufferStack.isEmpty()) {
                    plantsStack.push(bufferStack.pop());
                }
            } else {
                flag = false;
            }
        }
        System.out.println(days);
    }
}
