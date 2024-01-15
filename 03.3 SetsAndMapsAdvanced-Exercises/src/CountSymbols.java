import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Character, Integer> counts = new TreeMap<>();
        String line = input.nextLine();
        for (int i = 0; i < line.length(); i++) {
            counts.putIfAbsent(line.charAt(i), 0);
            counts.put(line.charAt(i), counts.get(line.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
