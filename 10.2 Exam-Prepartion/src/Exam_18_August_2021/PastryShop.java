package Exam_18_August_2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        //25, Biscuit
        //50, Cake
        //75, Pastry
        //100, Pie
        HashMap<Integer, String> food = new HashMap<>();
        food.put(25, "Biscuit");
        food.put(50, "Cake");
        food.put(75, "Pastry");
        food.put(100, "Pie");
        LinkedHashMap<String, Integer> made = new LinkedHashMap<>();
        made.put("Biscuit", 0);
        made.put("Cake", 0);
        made.put("Pie", 0);
        made.put("Pastry", 0);
        Scanner input = new Scanner(System.in);
        //sequence of integers, representing liquids
        List<Integer> liquids = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //sequence of integers representing ingredients
        List<Integer> ingredients = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(ingredients);
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.get(0);
            int ingredient = ingredients.get(0);
            int sum = liquid + ingredient;
            liquids.remove(0);
            ingredients.remove(0);
            if (food.containsKey(sum)) {
                String done = food.get(sum);
                made.put(done, made.get(done) + 1);
            } else {
                ingredients.add(0, ingredient + 3);
            }
        }
        StringBuilder text = new StringBuilder();
        StringBuilder ready = new StringBuilder();
        for (Map.Entry<String, Integer> entry : made.entrySet()) {
            ready.append(String.format("%s: %d", entry.getKey(), entry.getValue()));
            ready.append(System.lineSeparator());
            if (entry.getValue() == 0 && text.toString().length() == 0) {
                text.append("What a pity! You didn't have enough materials to cook everything.");
            }
        }
        if (text.toString().length() == 0) {
            text.append("Great! You succeeded in cooking all the food!");
        }
        text.append(System.lineSeparator());
        text.append("Liquids left: ");
        if (!liquids.isEmpty()) {
            for (int i = 0; i < liquids.size(); i++) {
                if (i < liquids.size() - 1) {
                    text.append(String.format("%s, ", liquids.get(i)));
                } else {
                    text.append(String.format("%s", liquids.get(i)));
                }
            }
        } else {
            text.append("none");
        }
        text.append(System.lineSeparator());
        text.append("Ingredients left: ");
        if (!ingredients.isEmpty()) {
            for (int i = 0; i < ingredients.size(); i++) {
                if (i < ingredients.size() - 1) {
                    text.append(String.format("%s, ", ingredients.get(i)));
                } else {
                    text.append(String.format("%s", ingredients.get(i)));
                }
            }
        } else {
            text.append("none");
        }
        text.append(System.lineSeparator());
        text.append(ready);
        System.out.print(text);
    }
}
