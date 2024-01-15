package Exam_19_August_2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> lilies = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> roses = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(roses);
        int wreathCount = 0;
        int stored = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lili = lilies.get(0);
            int rose = roses.get(0);
            int sum = lili + rose;
            if (sum == 15) {
                wreathCount++;
                lilies.remove(Integer.valueOf(lili));
                roses.remove(Integer.valueOf(rose));
            } else if (sum > 15) {
                lilies.set(0, lili - 2);
            } else {
                lilies.remove(Integer.valueOf(lili));
                roses.remove(Integer.valueOf(rose));
                stored += sum;
            }
        }
        wreathCount += stored / 15;
        stored %= 15;
        if (wreathCount < 5) {
            System.out.printf("You didn't make it, you need %d wreaths more!%n" , 5 - wreathCount);
        } else {
            System.out.printf("You made it, you are going to the competition with %d wreaths!" ,wreathCount);
        }
    }
}
