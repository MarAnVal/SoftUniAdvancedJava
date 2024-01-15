import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.Entry.comparingByValue;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //"{singer} @{venue} {ticketsPrice} {ticketsCount}"
        String line = input.nextLine();
        Map<String, Map<String, Long>> map = new LinkedHashMap<>();
        while (!line.equals("End")) {
            Pattern pattern = Pattern.compile("^(?<name>[a-zA-Z]+[\\s?a-zA-Z+]*)\\s@(?<venue>[a-zA-Z]+[\\s?a-zA-Z+]*)\\s(?<tickets>[0-9]+)\\s(?<people>[0-9]+)$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String name = matcher.group("name");
                String venue = matcher.group("venue");
                int tickets = Integer.parseInt(matcher.group("tickets"));
                int people = Integer.parseInt(matcher.group("people"));
                long totalSum = (long) tickets * people;
                map.putIfAbsent(venue, new LinkedHashMap<>());
                map.get(venue).putIfAbsent(name, 0L);
                map.get(venue).put(name, map.get(venue).get(name) + totalSum);

            }
            line = input.nextLine();
        }
        for (Map.Entry<String, Map<String, Long>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream().
                    sorted(Collections.reverseOrder(comparingByValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        }
    }
}
