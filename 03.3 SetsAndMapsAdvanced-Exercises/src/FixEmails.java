import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Set<String> wrongDomain = new HashSet<>();
        wrongDomain.add("us");
        wrongDomain.add("com");
        wrongDomain.add("uk");
        Map<String, String> contacts = new LinkedHashMap<>();
        while (!line.equals("stop")) {
            String name = line;
            String email = input.nextLine().toLowerCase();
            String[] parts = email.split("\\.");
            String domain = parts[parts.length - 1];
            if (!wrongDomain.contains(domain)) {
                contacts.put(name, email);
            }
            line = input.nextLine();
        }
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            //John -> johnDoe@softuni.org
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
