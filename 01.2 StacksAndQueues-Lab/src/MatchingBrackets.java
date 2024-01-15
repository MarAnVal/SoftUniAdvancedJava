import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ArrayDeque <Integer> bracketsIndex = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '('){
                bracketsIndex.push(i);
            } else if (line.charAt(i) == ')'){
                System.out.println(line.substring(bracketsIndex.pop(), i+1));

            }
        }

    }
}
