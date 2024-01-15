import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> num = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(input.nextLine());

        Collections.reverse(num);
        num.removeIf(e -> e % n == 0);
        num.forEach(e -> System.out.print(e + " "));
    }
}
