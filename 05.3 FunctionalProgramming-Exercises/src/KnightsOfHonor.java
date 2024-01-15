import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Consumer<String> print = e -> System.out.printf("Sir %s%n", e);
        Arrays.stream(input.nextLine().split("\\s+"))
                .forEach(e -> print.accept(e));
    }
}
