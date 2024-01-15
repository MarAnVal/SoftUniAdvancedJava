package Exam_14_April_2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // two sequences of integers, representing daffodils and tulips
        List<Integer> tulips = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> daffodilLists = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(tulips);
        //last tulips and the first daffodils
        //stop combining when you have no more daffodils or tulips
        int bouquets = 0;
        int stored = 0;
        while (!tulips.isEmpty() && !daffodilLists.isEmpty()) {
            int tulip = tulips.get(0);
            int daffodil = daffodilLists.get(0);
            int sum = tulip + daffodil;
            tulips.remove(0);
            daffodilLists.remove(0);
            while (sum > 15 && tulip > 0) {
                //While the sum is bigger than 15, keep decreasing the value of the tulips by 2
                tulip -= 2;
                sum = tulip + daffodil;
            }
            //If the sum of their values is equal to 15 – create one bouquet and remove them
            if (sum == 15) {
                bouquets++;
            } else {
                //If the sum is less than 15 you have to store them for later and remove them.
                //(stored r summed and divided at the end by 15 to be added the result to the made bouquets)
                stored += sum;
            }
        }
        //(stored r summed and divided at the end by 15 to be added the result to the made bouquets)
        bouquets += stored / 15;
        if (bouquets < 5) {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        } else {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        }
        System.out.println();
    }
}
