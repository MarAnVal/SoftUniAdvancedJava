import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayDeque<String> urls = new ArrayDeque<>();
        ArrayDeque<String> backHistory = new ArrayDeque<>();
        String line = input.nextLine();
        while (!line.equals("Home")) {
            boolean printed = false;
            switch (line) {
                case "back":
                    if (urls.size() <= 1) {
                        System.out.println("no previous URLs");
                        printed = true;
                    } else {
                        backHistory.push(urls.pop());
                    }
                    break;
                case "forward":
                    if (backHistory.isEmpty()){
                        System.out.println("no next URLs");
                        printed = true;
                    } else {
                        urls.push(backHistory.pop());
                    }
                    break;
                default:
                    urls.push(line);
                    backHistory.clear();
                    break;
            }
            if (!printed) {
                System.out.println(urls.peek());
            }
            line = input.nextLine();
        }

    }
}

