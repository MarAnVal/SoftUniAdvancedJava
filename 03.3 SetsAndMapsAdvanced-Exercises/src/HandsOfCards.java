import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        String line = input.nextLine();
        while (!line.equals("JOKER")) {
            String name = line.split(":\\s+")[0];
            String parts = line.split(":\\s+")[1];
            Pattern pattern = Pattern.compile("(?<power>[0-9A-Z]+)(?<type>[A-Z])");
            Matcher matcher = pattern.matcher(parts);
            while (matcher.find()) {
                String type = matcher.group("type");
                String power = matcher.group("power");
                String draw = matcher.group();
                int card = 0;
                switch (power) {
                    case "J":
                        card = 11;
                        break;
                    case "Q":
                        card = 12;
                        break;
                    case "K":
                        card = 13;
                        break;
                    case "A":
                        card = 14;
                        break;
                    default:
                        card = Integer.parseInt(power);
                        break;
                }
                switch (type) {
                    case "D":
                        card *= 2;
                        break;
                    case "H":
                        card *= 3;
                        break;
                    case "S":
                        card *= 4;
                        break;

                }
                map.putIfAbsent(name, new HashMap<>());
                map.get(name).put(draw, card);
            }
            line = input.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            int sum = 0;
            for (Map.Entry<String, Integer> amount : entry.getValue().entrySet()) {
                sum += amount.getValue();
            }
            //Peter: 167
            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }
    }
}
