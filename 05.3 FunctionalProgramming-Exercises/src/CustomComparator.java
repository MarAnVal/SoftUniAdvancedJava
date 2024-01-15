import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> num = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        num.stream().filter(e -> e % 2 == 0)
                .sorted().forEach(e -> System.out.print(e + " "));
        num.stream().filter(e -> e % 2 != 0)
                .sorted().forEach(e -> System.out.print(e + " "));
    }
}
