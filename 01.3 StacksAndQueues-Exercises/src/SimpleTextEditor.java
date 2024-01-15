import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        int n = Integer.parseInt(input.nextLine());
        ArrayDeque<String> textHistory = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            char command = line.charAt(0);
            switch (command) {
                case '1':
                    //"1 {string}" - appends [string] to the end of the text.
                    textHistory.push(text.toString());
                    String string = line.substring(2);
                    text.append(string);
                    break;
                case '2':
                    //"2 {count}" - erases the last [count] elements from the text
                    textHistory.push(text.toString());
                    int count = Integer.parseInt(line.substring(2));
                    text.delete(text.length() - count, text.length());
                    break;
                case '3':
                    //"3 {index}" - returns the element at position [index] from the text
                    int position = Integer.parseInt(line.substring(2)) - 1;
                    System.out.println(text.charAt(position));
                    break;
                case '4':
                    if (!textHistory.isEmpty()) {
                        text = new StringBuilder(textHistory.pop());
                    }
                    break;
            }

        }

    }
}
