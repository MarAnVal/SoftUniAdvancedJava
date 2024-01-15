import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        while(!line.equals("search")){
            String name = line.split("-")[0];
            String num = line.split("-")[1];
            phonebook.put(name, num);
            line = input.nextLine();
        }
        line = input.nextLine();
        while(!line.equals("stop")){
            if (phonebook.containsKey(line)){
                //John -> 0888080808
                System.out.printf("%s -> %s%n", line, phonebook.get(line));
            } else {
                //Contact Maria does not exist.
                System.out.printf("Contact %s does not exist.%n", line);
            }
            line = input.nextLine();
        }

    }
}
