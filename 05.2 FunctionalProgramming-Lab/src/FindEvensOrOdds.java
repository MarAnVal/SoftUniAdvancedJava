import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int start = Integer.parseInt(line.split("\\s+")[0]);
        int stop = Integer.parseInt(line.split("\\s+")[1]);
        String type = input.nextLine();

        Predicate<Integer> filter = type.equals("odd")
                ? (x -> x % 2 != 0) : (x -> x % 2 == 0);

        IntStream.range(start, stop + 1).filter(num -> filter.test(num))
                .forEach(num -> System.out.print(num + " "));
    }
}
