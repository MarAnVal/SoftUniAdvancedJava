import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayDeque<String> urls = new ArrayDeque<>();
        String line = input.nextLine();
        while (!line.equals("Home")) {
            boolean emptyBackline = false;
            if (line.equals("back")) {
                if (urls.size() <= 1) {
                    System.out.println("no previous URLs");
                    emptyBackline = true;
                } else {
                    urls.pop();
                }
            } else {
                urls.push(line);
            }
            if (!emptyBackline) {
                System.out.println(urls.peek());
            }
            line = input.nextLine();
        }
    }
}

