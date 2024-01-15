package Exam_25_June_2022;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        //Milk Chocolate 30%
        //Dark Chocolate 50%
        //Baking Chocolate 100%
        HashMap<Double, String> chocolatePercentage = new HashMap<>();
        TreeMap<String, Integer> madeChocolate = new TreeMap<>();
        chocolatePercentage.put(0.3, "Milk Chocolate");
        chocolatePercentage.put(0.5, "Dark Chocolate");
        chocolatePercentage.put(1.0, "Baking Chocolate");
        Scanner input = new Scanner(System.in);
        //sequence of doubles, representing the milk quantity
        String[] milkLine = input.nextLine().split("\\s+");
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        for (int i = 0; i < milkLine.length; i++) {
            milkQueue.offer(Double.parseDouble(milkLine[i]));
        }

        //sequence of doubles - the cacao powder quantity
        String[] cacaoLine = input.nextLine().split("\\s+");
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        for (int i = 0; i < cacaoLine.length; i++) {
            cacaoStack.push(Double.parseDouble(cacaoLine[i]));
        }
        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();
            double chocolateValue = cacao / (milk + cacao);
            if (chocolatePercentage.containsKey(chocolateValue)) {
                String chocolate = chocolatePercentage.get(chocolateValue);
                madeChocolate.putIfAbsent(chocolate, 0);
                madeChocolate.put(chocolate, madeChocolate.get(chocolate) + 1);
            } else {
                milkQueue.offer(milk);
            }
        }
        StringBuilder result = new StringBuilder();
        if (madeChocolate.size() < 3) {
            result.append("Sorry, but you didn't succeed to prepare all types of chocolates.");
        } else {
            result.append("It’s a Chocolate Time. All chocolate types are prepared.");
        }
        for (Map.Entry<String, Integer> entry : madeChocolate.entrySet()) {
            result.append(System.lineSeparator());
            result.append(String.format(" # %s --> %d", entry.getKey(), entry.getValue()));
        }
        System.out.println(result);
    }
}
