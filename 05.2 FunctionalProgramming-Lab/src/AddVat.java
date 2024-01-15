import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UnaryOperator<Double> addVat = e -> e * 1.2;
        Consumer<Double> print = price -> System.out.printf("%.2f%n", price);

        List<Double> prices = Arrays.stream(input.nextLine().split(",\\s+")).map(Double::parseDouble)
                .map(e -> addVat.apply(e)).collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        prices.forEach(e -> print.accept(e));
    }
}
