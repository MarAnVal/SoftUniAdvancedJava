import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayDeque<Integer> elements = new ArrayDeque<>();
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String command = line.split("\\s+")[0];
            switch (command) {
                case "1" :
                    int add = Integer.parseInt(line.split("\\s+")[1]);
                    elements.push(add);
                    break;
                case "2" :
                    if (!elements.isEmpty()) {
                        elements.pop();
                    }
                    break;
                case "3" :
                    if (!elements.isEmpty()){
                    System.out.println(Collections.max(elements));
                    } else {
                        System.out.println(0);
                    }
                    break;
            }

        }
    }
}

