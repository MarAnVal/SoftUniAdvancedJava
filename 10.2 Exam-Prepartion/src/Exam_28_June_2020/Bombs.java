package Exam_28_June_2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        //Datura Bombs: 40
        //Cherry Bombs: 60
        //Smoke Decoy Bombs: 120

        HashMap<Integer, String> bombs = new HashMap<>();
        bombs.put(60, "Cherry Bombs");
        bombs.put(40, "Datura Bombs");
        bombs.put(120, "Smoke Decoy Bombs");
        LinkedHashMap<String, Integer> made = new LinkedHashMap<>();
        made.put("Cherry Bombs", 0);
        made.put("Datura Bombs", 0);
        made.put("Smoke Decoy Bombs", 0);
        Scanner input = new Scanner(System.in);
        List<Integer> effectsList = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> casingList = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(casingList);
        boolean all = false;
        while (!effectsList.isEmpty() && !casingList.isEmpty()) {
            all = true;
            int effects = effectsList.get(0);
            int casing = casingList.get(0);
            int sum = effects + casing;
            if(bombs.containsKey(sum)){
                effectsList.remove(Integer.valueOf(effects));
                casingList.remove(Integer.valueOf(casing));
                String bomb = bombs.get(sum);
                made.put(bomb, made.get(bomb) + 1);
                for (Map.Entry<String, Integer> entry : made.entrySet()) {
                    if (entry.getValue() < 3){
                        all = false;
                    }
                }
                if(all){
                    System.out.println("Bene! You have successfully filled the bomb pouch!");
                    break;
                }
            } else {
                casingList.set(0, casing - 5);
            }
        }
        if (!all){
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if(effectsList.isEmpty()){
            System.out.println("empty");
        } else {
            for (int i = 0; i < effectsList.size(); i++) {
                if (i < effectsList.size() - 1){
                    System.out.printf("%d, ", effectsList.get(i));
                } else {
                    System.out.println(effectsList.get(i));
                }
            }
        }
        System.out.print("Bomb Casings: ");
        if(casingList.isEmpty()){
            System.out.println("empty");
        } else {
            for (int i = 0; i < casingList.size(); i++) {
                if (i < casingList.size() - 1){
                    System.out.printf("%d, ", casingList.get(i));
                } else {
                    System.out.println(casingList.get(i));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : made.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
