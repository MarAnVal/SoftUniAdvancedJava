import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            List<String> line = Arrays.stream(input.nextLine().split("\\s+")).collect(Collectors.toList());
            elements.addAll(line);
        }
        System.out.println(String.join(" ", elements));
    }
}
