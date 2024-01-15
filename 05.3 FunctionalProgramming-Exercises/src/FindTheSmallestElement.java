import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> num = Arrays.stream(input.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        int min = Collections.min(num);
        System.out.println(num.lastIndexOf(min));

    }
}
