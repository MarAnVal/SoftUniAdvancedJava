package Exam_23_October_2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        //Pear Sour 150
        //The Harvest 250
        //Apple Hinny 300
        //High Fashion 400
        HashMap<Integer, String> cocktails = new HashMap<>();
        cocktails.put(150, "Pear Sour");
        cocktails.put(250, "The Harvest");
        cocktails.put(300, "Apple Hinny");
        cocktails.put(400, "High Fashion");
        TreeMap<String, Integer> made = new TreeMap<>();
        made.put("Pear Sour", 0);
        made.put("The Harvest", 0);
        made.put("Apple Hinny", 0);
        made.put("High Fashion", 0);
        Scanner input = new Scanner(System.in);

        List<Integer> bucket = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).filter(e -> e > 0).collect(Collectors.toList());
        List<Integer> fresh = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(fresh);

        while (!bucket.isEmpty() && !fresh.isEmpty()) {
            int ingredient = bucket.get(0);
            bucket.remove(0);
            int fLevel = fresh.get(0);
            fresh.remove(0);
            int mix = ingredient * fLevel;
            if (cocktails.containsKey(mix)) {
                String key = cocktails.get(mix);
                made.put(key, made.get(key) + 1);
            } else {
                ingredient += 5;
                bucket.add(ingredient);
            }
        }
        StringBuilder left = new StringBuilder();
        if (!bucket.isEmpty()) {
            int sum = bucket.stream().mapToInt(e -> e).sum();
            left.append(String.format("Ingredients left: %d", sum));
        }
        boolean madeAll = true;
        StringBuilder ready = new StringBuilder();
        for (Map.Entry<String, Integer> entry : made.entrySet()) {
            if (entry.getValue() > 0) {
                ready.append(System.lineSeparator());
                ready.append(String.format(" # %s --> %d", entry.getKey(), entry.getValue()));
            } else {
                madeAll = false;
            }
        }
        StringBuilder text = new StringBuilder();
        if (madeAll) {
            text.append("It's party time! The cocktails are ready!");
        } else {
            text.append("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (left.toString().length() > 0) {
            text.append(System.lineSeparator());
            text.append(left);
        }
        text.append(ready);
        System.out.println(text);
    }
}
