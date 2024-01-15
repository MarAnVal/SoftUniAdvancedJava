import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> names = Arrays.stream(input.nextLine().split("\\s+")).collect(Collectors.toList());

        String line = input.nextLine();
        while (!line.equals("Party!")) {
            String command = line.split("\\s+")[0];
            String toDo = line.split("\\s+")[1];
            String text = line.split("\\s+")[2];

            Predicate<String> startWith = name ->
                    name.startsWith(text);
            Predicate<String> endWith = name ->
                    name.endsWith(text);
            Predicate<String> nameLength = (name -> {
                int length = Integer.parseInt(text);
                return name.length() == length;
            });
            List<String> buffer = new ArrayList<>();

            switch (toDo) {
                case "StartsWith":
                    buffer = names.stream().filter(e -> startWith.test(e)).collect(Collectors.toList());
                    break;
                case "EndsWith":
                    buffer = names.stream().filter(e -> endWith.test(e)).collect(Collectors.toList());
                    break;
                case "Length":
                    buffer = names.stream().filter(e -> nameLength.test(e)).collect(Collectors.toList());
                    break;

            }
            switch (command) {
                case "Remove":
                    names.removeAll(buffer);
                    break;
                case "Double":
                    names.addAll(buffer);
                    break;
            }

            line = input.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            names.sort(String::compareTo);
            System.out.printf("%s are going to the party!", String.join(", ", names));
        }
    }
}
