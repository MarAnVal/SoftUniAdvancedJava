import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> num = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = input.nextLine();
        Function<List<Integer>, List<Integer>> addCommand = list ->
                list.stream().map(e -> e= e + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyCommand = list ->
                list.stream().map(e -> e = e * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractCommand = list ->
                list.stream().map(e -> e= e - 1).collect(Collectors.toList());
        Consumer<List<Integer>> printCommand = list ->
                list.forEach(e -> System.out.print(e + " "));
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    num = addCommand.apply(num);
                    break;
                case "multiply":
                    num = multiplyCommand.apply(num);
                    break;
                case "subtract":
                    num = subtractCommand.apply(num);
                    break;
                case "print":
                    printCommand.accept(num);
                    System.out.println();
                    break;
            }

            command = input.nextLine();
        }

    }
}
