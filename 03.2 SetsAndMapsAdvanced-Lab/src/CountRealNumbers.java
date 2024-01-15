import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line = input.nextLine().split("\\s+");
        Map<Double, Integer> numbers = new LinkedHashMap<>();
        for (int i = 0; i < line.length; i++) {
            double key = Double.parseDouble(line[i]);
            numbers.putIfAbsent(key, 0);
            numbers.put(key, numbers.get(key) + 1);
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue());
        }


    }
}
