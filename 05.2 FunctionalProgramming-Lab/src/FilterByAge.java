import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
           String line = input.nextLine();
           String name = line.split(",\\s+")[0];
           int age = Integer.parseInt(line.split(",\\s+")[1]);
           people.put(name, age);
        }
        String condition = input.nextLine();
        int age = Integer.parseInt(input.nextLine());
        String data = input.nextLine();

        Predicate<Integer> filter = getPredicate(condition, age);
        Consumer<Map.Entry<String, Integer>> print = printCondition(data);

        people.entrySet().stream().filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }
    private static Predicate<Integer> getPredicate(String condition, int age){
        if (condition.equals("older")){
            return x -> x>= age;
        } else if (condition.equals("younger")){
            return x -> x<= age;
        }
        throw new RuntimeException("error");
    }
    private static Consumer<Map.Entry<String, Integer>> printCondition(String data){
        if(data.equals("name")){
            return e -> System.out.println(e.getKey());
        } else if(data.equals("age")){
            return e -> System.out.println(e.getValue());
        } else if(data.equals("name age")){
            return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
        throw new RuntimeException("error");
    }
}
