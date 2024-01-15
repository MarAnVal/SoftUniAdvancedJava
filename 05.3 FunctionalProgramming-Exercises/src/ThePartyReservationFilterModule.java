import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> start = Arrays.stream(input.nextLine().split("\\s+")).collect(Collectors.toList());
        String line = input.nextLine();
        List<String> filtersList = new ArrayList<>();
        while (!line.equals("Print")) {
            String command = line.split(";")[0];
            String filterCommand = line.split(";")[1] + ";" + line.split(";")[2];
            switch (command) {
                case "Add filter":
                    filtersList.add(filterCommand);
                    break;
                case "Remove filter":
                    filtersList.remove(filterCommand);
                    break;
            }


            line = input.nextLine();
        }

        List<String> buffer = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.addAll(start);
        while (!filtersList.isEmpty()) {
            String commandLine = filtersList.get(0);
            filtersList.remove(0);
            String toDo = commandLine.split(";")[0];
            String text = commandLine.split(";")[1];
            Predicate<String> startWith = name ->
                    name.startsWith(text);
            Predicate<String> endWith = name ->
                    name.endsWith(text);
            Predicate<String> nameLength = (name -> {
                int length = Integer.parseInt(text);
                return name.length() == length;
            });
            Predicate<String> nameContains = name ->
                    name.contains(text);

            switch (toDo) {
                case "Starts with":
                    buffer = start.stream().filter(e -> startWith.test(e)).collect(Collectors.toList());
                                        break;
                case "Ends with":
                    buffer = start.stream().filter(e -> endWith.test(e)).collect(Collectors.toList());
                    break;
                case "Length":
                    buffer = start.stream().filter(e -> nameLength.test(e)).collect(Collectors.toList());
                    break;
                case "Contains":
                    buffer = start.stream().filter(e -> nameContains.test(e)).collect(Collectors.toList());
                    break;
            }

            result.removeAll(buffer);
        }
        if (result.size() > 0) {

            System.out.print(String.join(" ", result));
        }
        System.out.println();
    }
}