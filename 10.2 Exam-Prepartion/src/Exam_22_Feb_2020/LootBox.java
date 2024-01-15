package Exam_22_Feb_2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> firstBox = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondBox = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(secondBox);
        int collected = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.get(0);
            int secondItem = secondBox.get(0);
            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                firstBox.remove(Integer.valueOf(firstItem));
                secondBox.remove(Integer.valueOf(secondItem));
                collected+=sum;
            } else {
                secondBox.remove(Integer.valueOf(secondItem));
                firstBox.add(secondItem);
            }
            if(firstBox.isEmpty()){
                System.out.println("First lootbox is empty");
            } else if (secondBox.isEmpty()) {
                System.out.println("Second lootbox is empty");
            }
        }
        if(collected < 100){
            System.out.printf("Your loot was poor... Value: %d%n", collected);
        }else {
            System.out.printf("Your loot was epic! Value: %d%n", collected);
        }
    }
}
