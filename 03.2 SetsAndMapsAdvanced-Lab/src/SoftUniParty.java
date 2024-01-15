import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeSet<String> guests = new TreeSet<>();
        String line = input.nextLine();
        while (!line.equals("PARTY")) {
            guests.add(line);
            line = input.nextLine();
        }
        line = input.nextLine();
        while (!line.equals("END")) {
            guests.remove(line);
            line = input.nextLine();
        }
        if (!guests.isEmpty()) {
            System.out.println(guests.size());
            guests.forEach(e -> System.out.println(e));
        } else {
            System.out.println(0);
        }
    }
}
