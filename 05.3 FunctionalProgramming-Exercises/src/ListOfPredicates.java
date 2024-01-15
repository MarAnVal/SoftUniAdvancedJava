import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Integer> num = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) -> {
            for (int numInList : list) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int i = 1; i <= n; i++) {
            if(isDivisible.apply(i, num)){
                System.out.print(i + " ");
            }
        }
    }
}
