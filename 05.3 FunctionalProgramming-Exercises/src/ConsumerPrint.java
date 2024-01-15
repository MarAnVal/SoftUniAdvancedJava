import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Consumer<String> printName = e -> System.out.println(e);
        Arrays.stream(input.nextLine().split("\\s+"))
                .forEach(e ->printName.accept(e));
    }
}
