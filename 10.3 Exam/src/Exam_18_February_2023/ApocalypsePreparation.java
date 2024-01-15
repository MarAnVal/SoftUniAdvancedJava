package Exam_18_February_2023;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        //30, "Patch"
        //40, "Bandage"
        //100, "MedKit"
        HashMap<Integer, String> items = new HashMap<>();
        items.put(30, "Patch");
        items.put(40, "Bandage");
        items.put(100, "MedKit");
        LinkedHashMap<String, Integer> made = new LinkedHashMap<>();
        made.put("Bandage", 0);
        made.put("MedKit", 0);
        made.put("Patch", 0);
        Scanner input = new Scanner(System.in);
        //sequence representing textiles
        List<Integer> textiles = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //sequence represents medicaments
        List<Integer> medicaments = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(medicaments);
        //first value of textile and the last value of medicaments

        //While both collections contain any elements
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int med = medicaments.get(0);
            int tex = textiles.get(0);
            int mix = med + tex;
            //if their sum is equal to any of the items in the table below create that item and remove both values.
            if (items.containsKey(mix)) {
                medicaments.remove(0);
                textiles.remove(0);
                String key = items.get(mix);
                made.put(key, made.get(key) + 1);
            } else if (mix > 100) {
                //Otherwise, check if the sum is bigger than the value of the MedKit, create the MedKit,
                // remove both values, and add the remaining resources(of the sum) to the next value
                // in the medicament collection (Take the element from the collection,
                // add the remaining sum to it, and put the element back to its place).
                mix -= 100;
                String key = items.get(100);
                made.put(key, made.get(key) + 1);
                medicaments.remove(0);
                med = medicaments.get(0);
                medicaments.set(0, Integer.valueOf((med + mix)));
                textiles.remove(0);
            } else {
                //If you can’t create anything, remove the textile value, add 10 to the medicament value,
                // and return the medicament back to its place, into its collection.
                textiles.remove(0);
                medicaments.set(0, med + 10);
            }
        }

        made = made.entrySet().stream().
                sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        StringBuilder madeItems = new StringBuilder();
        for (Map.Entry<String, Integer> entry : made.entrySet()) {
            if (entry.getValue() > 0) {
                madeItems.append(String.format("%s - %d", entry.getKey(), entry.getValue()));
                madeItems.append(System.lineSeparator());
            }
        }


        if (medicaments.isEmpty() && textiles.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            System.out.print(madeItems.toString());
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
            //"Textiles left: {textile1}, {textile2}…"
            madeItems.append("Textiles left: ");
            for (int i = 0; i < textiles.size(); i++) {
                if (i < textiles.size() - 1) {
                    madeItems.append(String.format("%d, ", textiles.get(i)));
                } else {
                    madeItems.append(textiles.get(i));
                }
            }
            System.out.println(madeItems);
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
            //"Medicaments left: {medicament1}, {medicament2}…"
            madeItems.append("Medicaments left: ");
            for (int i = 0; i < medicaments.size(); i++) {
                if (i < medicaments.size() - 1) {
                    madeItems.append(String.format("%d, ", medicaments.get(i)));
                } else {
                    madeItems.append(medicaments.get(i));
                }
            }
            System.out.println(madeItems.toString());
        }


    }
}
