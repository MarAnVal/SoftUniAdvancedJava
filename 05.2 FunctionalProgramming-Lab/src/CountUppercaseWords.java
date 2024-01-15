import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> words = Arrays.stream(input.nextLine().split("\\s"))
                .filter(e -> Character.isUpperCase(e.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(words.size());
        words.forEach(e -> System.out.println(e));

    }
}
