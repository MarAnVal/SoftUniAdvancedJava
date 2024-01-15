import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Function<String, Integer> parse = s -> Integer.parseInt(s);

        List<Integer> num = Arrays.stream(input.nextLine().split(",\\s+")).map(e -> parse.apply(e))
        .collect(Collectors.toList());
        int sum = num.stream().mapToInt(a -> a).sum();
        //Count = 10
        // Sum = 41
        System.out.printf("Count = %d%n", num.size());
        System.out.printf("Sum = %d%n", sum);
    }
}
