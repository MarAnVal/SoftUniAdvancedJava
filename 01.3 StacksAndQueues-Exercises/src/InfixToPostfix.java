import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class InfixToPostfix {
    public static String brackets(String text) {
        ArrayDeque<String> bufferFirstQueue = new ArrayDeque<>();
        Collections.addAll(bufferFirstQueue, text.split("\\s+"));
        ArrayDeque<String> bufferSecondQueue = new ArrayDeque<>();
        String result = "";
        String redirect = "";
        while (bufferFirstQueue.contains(")")) {
            String currentElement = bufferFirstQueue.pop();
            if (currentElement.equals(")")) {
                currentElement = bufferSecondQueue.pop();
                while (!currentElement.equals("(")) {
                    if (redirect.length() < 1) {
                        redirect = currentElement;
                    } else {
                        redirect = String.format("%s|%s", currentElement, redirect);
                    }
                    currentElement = bufferSecondQueue.pop();
                }
                bufferFirstQueue.push(priority(redirect));
                redirect = "";
            } else {
                bufferSecondQueue.push(currentElement);
            }
        }
        while (!bufferSecondQueue.isEmpty()) {
            bufferFirstQueue.push(bufferSecondQueue.pop());
        }
        while (!bufferFirstQueue.isEmpty()) {
            if (redirect.isEmpty()) {
                redirect = bufferFirstQueue.pop();
            } else {
                redirect = String.format("%s|%s", redirect, bufferFirstQueue.pop());
            }
        }
        result = priority(redirect);
        return result;
    }

    public static String priority(String text) {
        ArrayDeque<String> bufferFirstQueue = new ArrayDeque<>();
        Collections.addAll(bufferFirstQueue, text.split("\\|"));
        ArrayDeque<String> bufferSecondQueue = new ArrayDeque<>();
        String result = "";
        while (bufferFirstQueue.contains("*") || bufferFirstQueue.contains("/")) {
            String currentElement = bufferFirstQueue.pop();
            if (currentElement.equals("*") || currentElement.equals("/")) {
                String first = bufferSecondQueue.pop();
                String second = bufferFirstQueue.pop();
                bufferFirstQueue.push(String.format("%s %s %s", first, second, currentElement));
            } else {
                bufferSecondQueue.push(currentElement);
            }

        }
        while (!bufferSecondQueue.isEmpty()) {
            bufferFirstQueue.push(bufferSecondQueue.pop());
        }
        while (bufferFirstQueue.contains("-") || bufferFirstQueue.contains("+")) {
            String currentElement = bufferFirstQueue.pop();
            if (currentElement.equals("-") || currentElement.equals("+")) {
                String first = bufferSecondQueue.pop();
                String second = bufferFirstQueue.pop();
                bufferFirstQueue.push(String.format("%s %s %s", first, second, currentElement));
            } else {
                bufferSecondQueue.push(currentElement);
            }

        }
        while (!bufferSecondQueue.isEmpty()) {
            bufferFirstQueue.push(bufferSecondQueue.pop());
        }
        while (!bufferFirstQueue.isEmpty()) {
            if (result.isEmpty()) {
                result = bufferFirstQueue.pop();
            } else {
                result = String.format("%s %s", result, bufferFirstQueue.pop());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        line = brackets(line);
        System.out.println(line);
    }
}
