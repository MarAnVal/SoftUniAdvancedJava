import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            usernames.add(line);
        }
        usernames.forEach(e -> System.out.println(e));
    }
}
