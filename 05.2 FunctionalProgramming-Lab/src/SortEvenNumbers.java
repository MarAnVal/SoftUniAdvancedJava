import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(e -> Integer.parseInt(e)).filter(e -> e % 2 == 0).collect(Collectors.toList());
        List<String> evenStr = numbers.stream().map(e -> e.toString()).collect(Collectors.toList());
        System.out.println(String.join(", ", evenStr));
        Collections.sort(numbers);
        evenStr = numbers.stream().map(e -> e.toString()).collect(Collectors.toList());
        System.out.println(String.join(", ", evenStr));
    }
}
