package Exam_13_April_2022;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        //Gladius 70
        //Shamshir 80
        //Katana 90
        //Sabre 110
        HashMap<Integer, String> swords = new HashMap<>();
        swords.put(70, "Gladius");
        swords.put(80, "Shamshir");
        swords.put(90, "Katana");
        swords.put(110, "Sabre");
        LinkedHashMap<String, Integer> madeSwords = new LinkedHashMap<>();
        madeSwords.put("Gladius", 0);
        madeSwords.put("Katana", 0);
        madeSwords.put("Sabre", 0);
        madeSwords.put("Shamshir", 0);

        Scanner input = new Scanner(System.in);
        //First, you will be given a sequence representing steel.
        String[] steelLine = input.nextLine().split("\\s+");
        //Afterward, you will be given another sequence representing carbon.
        String[] carbonLine = input.nextLine().split("\\s+");
        //You should start from the first steel and try to mix it with the last carbon.
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        for (int i = 0; i < steelLine.length; i++) {
            steelQueue.offer(Integer.parseInt(steelLine[i]));
        }
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        for (int i = 0; i < carbonLine.length; i++) {
            carbonStack.push(Integer.parseInt(carbonLine[i]));
        }
        int count = 0;
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int total = steel + carbon;
            if (swords.containsKey(total)) {
                String sword = swords.get(total);
                madeSwords.put(sword, madeSwords.get(sword) + 1);
                count++;
            } else {
                carbon += 5;
                carbonStack.push(carbon);
            }
        }

        StringBuilder steel = new StringBuilder();
        //On the second line - print all steel you have left:
        //If there are no steel: "Steel left: none"
        //If there are steel:  {steel1}, {steel2}, {steel3}, (…)"
        steel.append("Steel left:");
        if (!steelQueue.isEmpty()) {
            while (!steelQueue.isEmpty()) {
                if (steelQueue.size() > 1) {
                    steel.append(String.format(" %s,", steelQueue.poll()));
                } else {
                    steel.append(String.format(" %s", steelQueue.poll()));
                }
            }
        } else {
            steel.append(" none");
        }
        StringBuilder carbon = new StringBuilder();
        carbon.append("Carbon left:");
        if (!carbonStack.isEmpty()) {
            while (!carbonStack.isEmpty()) {
                if (carbonStack.size() > 1) {
                    carbon.append(String.format(" %s,", carbonStack.pop()));
                } else {
                    carbon.append(String.format(" %s", carbonStack.pop()));
                }
            }
        } else {
            carbon.append(" none");
        }
        StringBuilder result = new StringBuilder();
        //On the first line of output depending on the result:
        //If at least one sword was forged: "You have forged {totalNumberOfSwords} swords."
        //If no sword was forged: "You did not have enough resources to forge a sword."
        if (count > 0) {
            StringBuilder matrix = new StringBuilder();
            for (Map.Entry<String, Integer> entry : madeSwords.entrySet()) {
                if (entry.getValue() > 0){
                    matrix.append(System.lineSeparator());
                    matrix.append(String.format("%s: %d", entry.getKey(), entry.getValue()));
                }
            }
            result.append(String.format("You have forged %s swords.", count));
            result.append(System.lineSeparator());
            result.append(steel);
            result.append(System.lineSeparator());
            result.append(carbon);
            result.append(matrix);

        } else {
            result.append("You did not have enough resources to forge a sword.");
            result.append(System.lineSeparator());
            result.append(steel);
            result.append(System.lineSeparator());
            result.append(carbon);
        }
        System.out.println(result);
    }
}
