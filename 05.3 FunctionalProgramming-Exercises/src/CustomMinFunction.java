import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Consumer<List<Integer>> printMin = e -> System.out.println(Collections.min(e));
        Function<List<Integer>, Integer> getMin = e -> Collections.min(e);
        List<Integer> num = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //printMin.accept(num);
        System.out.println(getMin.apply(num));

    }
}
