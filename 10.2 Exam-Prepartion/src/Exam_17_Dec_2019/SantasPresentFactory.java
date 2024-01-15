package Exam_17_Dec_2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        HashMap<Integer, String> toys = new HashMap<>();
        //150, Doll
        //250, Wooden train
        //300, Teddy bear
        //400, Bicycle
        toys.put(150, "Doll");
        toys.put(250, "Wooden train");
        toys.put(300, "Teddy bear");
        toys.put(400, "Bicycle");
        TreeMap<String, Integer> made = new TreeMap<>();
        made.put("Doll", 0);
        made.put("Wooden train", 0);
        made.put("Teddy bear", 0);
        made.put("Bicycle", 0);

        Scanner input = new Scanner(System.in);
        List<Integer> materialList = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).filter(e -> e != 0).collect(Collectors.toList());
        Collections.reverse(materialList);
        List<Integer> magicList = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).filter(e -> e != 0).collect(Collectors.toList());

        while (!materialList.isEmpty() && !magicList.isEmpty()) {
            int material = materialList.get(0);
            int magic = magicList.get(0);
            int result = magic * material;
            //result = materials*magic
            if (result < 0) {
                //if result < 0 remove both and put result as next material
                result = material + magic;
                materialList.set(0, result);
                magicList.remove(0);
            } else {
                //if resul > 0 but not right for present remove magic and materials stay and increase +15
                //if element is 0 remove it
                if (toys.containsKey(result)) {
                    magicList.remove(0);
                    materialList.remove(0);
                    String toy = toys.get(result);
                    made.put(toy, made.get(toy) + 1);
                } else {
                    magicList.remove(0);
                    materialList.set(0, material + 15);
                }
                materialList = materialList.stream().filter(e -> e != 0).collect(Collectors.toList());
                magicList = magicList.stream().filter(e -> e != 0).collect(Collectors.toList());
            }
        }
        if ((made.get("Doll") > 0 && made.get("Wooden train") > 0) ||
                (made.get("Teddy bear") > 0 && made.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialList.isEmpty()) {
            System.out.print("Materials left: ");
            for (int i = 0; i < materialList.size(); i++) {
                if (i < materialList.size() - 1) {
                    System.out.printf("%d, ", materialList.get(i));
                } else {
                    System.out.println(materialList.get(i));
                }
            }
        }
        if (!magicList.isEmpty()) {
            System.out.print("Magic left: ");
            for (int i = 0; i < magicList.size(); i++) {
                if (i < magicList.size() - 1) {
                    System.out.printf("%d, ", magicList.get(i));
                } else {
                    System.out.println(magicList.get(i));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : made.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }

    }
}
