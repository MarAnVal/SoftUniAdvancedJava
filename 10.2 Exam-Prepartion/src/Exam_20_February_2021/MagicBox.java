package Exam_20_February_2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //sequence of integers, representing the first magic box
        List<Integer> firstBox = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //sequence of integers representing the second magic box
        List<Integer> secondBox = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(secondBox);
        int collected = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            //first item in the first box and sum it up with the last item in the second box
            int firstItem = firstBox.get(0);
            int secondItem = secondBox.get(0);
            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                //If the sum of their values is an even number,
                // add the summed item to your collection of claimed items and remove them both from the boxes
                collected += firstItem + secondItem;
                firstBox.remove(0);
                secondBox.remove(0);
            } else {
                //If the sum of their values is odd number,
                //remove the last item from the second box and add it to the last position in the first box.
                secondBox.remove(0);
                firstBox.add(secondItem);
            }
        }
        //If a magic box became empty print:
        //"{First/Second} magic box is empty."
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        //If the sum of the claimed items is equal to or greater than 90, print:
        //"Wow, your prey was epic! Value: {sum of claimed items}"
        //Else print:
        //"Poor prey... Value: {sum of claimed items}"
        if (collected < 90) {
            System.out.printf("Poor prey... Value: %d%n", collected);
        } else {
            System.out.printf("Wow, your prey was epic! Value: %d%n", collected);
        }

    }
}
