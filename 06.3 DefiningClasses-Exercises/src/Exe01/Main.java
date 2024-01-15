package Exe01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        TreeMap<String, List<Integer>> personsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
           String name = line[0];
           int age = Integer.parseInt(line[1]);
           if(age > 30){
               personsMap.putIfAbsent(name, new ArrayList<>());
               personsMap.get(name).add(age);
           }
        }
        for (Map.Entry<String, List<Integer>> entry : personsMap.entrySet()) {
            entry.getValue().forEach(e -> System.out.printf("%s - %d%n", entry.getKey(), e));
        }

    }
}
