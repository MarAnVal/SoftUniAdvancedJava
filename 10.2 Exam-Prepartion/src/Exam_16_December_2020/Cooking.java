package Exam_16_December_2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        //25, Bread
        //50, Cake
        //75, Pastry
        //100, Fruit Pie
        HashMap<Integer, String> food = new HashMap<>();
        food.put(25, "Bread");
        food.put(50, "Cake");
        food.put(75, "Pastry");
        food.put(100, "Fruit Pie");
        TreeMap<String, Integer> made = new TreeMap<>();
        made.put("Bread", 0);
        made.put("Cake", 0);
        made.put("Pastry", 0);
        made.put("Fruit Pie", 0);
        Scanner input = new Scanner(System.in);
        //On the first line, you will receive the integers representing the liquids, separated by a single space.
        List<Integer> liquidsList = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //On the second line, you will receive the integers representing the ingredients, separated by a single space
        List<Integer> ingredientsList = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(ingredientsList);
        //first liquid and try to mix it with the last ingredient
        while (!liquidsList.isEmpty() && !ingredientsList.isEmpty()) {
            int liquid = liquidsList.get(0);
            liquidsList.remove(0);
            int ingredient = ingredientsList.get(0);
            int sum = liquid + ingredient;
            //sum of their values is equal to any of the items in the table below – cook the food
            // corresponding to the value and remove both the liquid and the ingredient.
            if (food.containsKey(sum)) {
                String madeFood = food.get(sum);
                made.put(madeFood, made.get(madeFood) + 1);
                ingredientsList.remove(0);
            } else {
                // Otherwise, remove only the liquid and increase the value of the ingredient by 3
                ingredientsList.set(0, ingredient + 3);
            }

        }
        StringBuilder text = new StringBuilder();
        //"Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
        text.append("Liquids left: ");
        if (liquidsList.isEmpty()) {
            text.append("none");
        } else {
            for (int i = 0; i < liquidsList.size(); i++) {
                if (i < liquidsList.size() - 1) {
                    text.append(String.format("%d, ", liquidsList.get(i)));
                } else {
                    text.append(liquidsList.get(i));
                }
            }
        }
        //"Ingredients left: {ingredient}, {ingredient}, {ingredient}, (…)"
        text.append(System.lineSeparator());
        text.append("Ingredients left: ");
        if (ingredientsList.isEmpty()) {
            text.append("none");
        } else {
            for (int i = 0; i < ingredientsList.size(); i++) {
                if (i < ingredientsList.size() - 1) {
                    text.append(String.format("%d, ", ingredientsList.get(i)));
                } else {
                    text.append(ingredientsList.get(i));
                }
            }
        }

        boolean all = true;
        for (
                Map.Entry<String, Integer> entry : made.entrySet()) {
            text.append(System.lineSeparator());
            text.append(String.format("%s: %d", entry.getKey(), entry.getValue()));
            if (entry.getValue() < 1) {
                all = false;
            }
        }
        if (all) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println(text);
    }
}
