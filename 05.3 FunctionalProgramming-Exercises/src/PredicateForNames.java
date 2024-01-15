import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<String> words = Arrays.stream(input.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> isSorter = e -> e.length() > n;
        words.removeIf(isSorter);
        words.forEach(e -> System.out.println(e));
    }
}
