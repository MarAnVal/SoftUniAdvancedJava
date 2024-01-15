import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, String> typeNameStats = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> typeNameCount = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> typeAverage = new LinkedHashMap<>();
        //"{type} {name} {damage} {health} {armor}"
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String type = line.split(" ")[0];
            String name = line.split(" ")[1];
            String damage = line.split(" ")[2];
            String health = line.split(" ")[3];
            String armor = line.split(" ")[4];
            String typeName = String.format("%s %s", type, name);
            //health 250, damage 45, and armor 10. Missing stat will be marked by null
            if (damage.equals("null")) {
                damage = "45";
            }
            if (health.equals("null")) {
                health = "250";
            }
            if (armor.equals("null")) {
                armor = "10";
            }
            String stats = String.format("%s %s %s",damage, health, armor);
            if (!typeNameStats.containsKey(typeName)) {
                typeNameStats.put(typeName, stats);
                typeNameCount.putIfAbsent(type, new ArrayList<>());
                typeNameCount.get(type).add(name);
                if (!typeAverage.containsKey(type)) {
                    typeAverage.put(type, new ArrayList<>());
                    typeAverage.get(type).add(Double.parseDouble(damage));
                    typeAverage.get(type).add(Double.parseDouble(health));
                    typeAverage.get(type).add(Double.parseDouble(armor));
                } else {
                    typeAverage.get(type).set(0, typeAverage.get(type).get(0) + Double.parseDouble(damage));
                    typeAverage.get(type).set(1, typeAverage.get(type).get(1) + Double.parseDouble(health));
                    typeAverage.get(type).set(2, typeAverage.get(type).get(2) + Double.parseDouble(armor));

                }

            } else {
                typeAverage.get(type).set(0, typeAverage.get(type).get(0) + Double.parseDouble(damage) -
                        Double.parseDouble(typeNameStats.get(typeName).split(" ")[0]));
                typeAverage.get(type).set(1, typeAverage.get(type).get(1) + Double.parseDouble(health) -
                        Double.parseDouble(typeNameStats.get(typeName).split(" ")[1]));
                typeAverage.get(type).set(2, typeAverage.get(type).get(2) + Double.parseDouble(armor) -
                        Double.parseDouble(typeNameStats.get(typeName).split(" ")[2]));
                typeNameStats.put(typeName, stats);
            }
        }


        for (Map.Entry<String, List<Double>> entry : typeAverage.entrySet()) {
            //"{Type}::({damage}/{health}/{armor})".
            double count = typeNameCount.get(entry.getKey()).size();
            double damage = entry.getValue().get(0);
            if (damage != 0){
                damage /= count;
            }
            double health = entry.getValue().get(1);
            if (health != 0){
                health /= count;
            }
            double armor = entry.getValue().get(2);
            if (armor != 0){
                armor /= count;
            }
            String type = entry.getKey();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, damage, health, armor);
            //"-{Name} -> damage: {damage}, health: {health}, armor: {armor}"
            Collections.sort(typeNameCount.get(type));
            for (int i = 0; i < typeNameCount.get(type).size(); i++) {
                String name = typeNameCount.get(type).get(i);
                String stats = typeNameStats.get(type + " " + name);
                System.out.printf("-%s -> damage: %s, health: %s, armor: %s%n", name, stats.split(" ")[0],
                        stats.split(" ")[1], stats.split(" ")[2]);
            }

        }
    }
}
