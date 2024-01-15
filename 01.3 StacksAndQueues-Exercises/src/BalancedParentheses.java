import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap <Character, Character> braketsMap = new HashMap<>();
        braketsMap.put(')', '(');
        braketsMap.put('}', '{');
        braketsMap.put(']', '[');
        ArrayDeque <Character> open = new ArrayDeque<>();
        String line = input.nextLine();
        boolean balanced = true;

        for (int i = 0; i < line.length(); i++) {
            if (braketsMap.containsValue(line.charAt(i))) {
                open.push(line.charAt(i));
            } else if (braketsMap.containsKey(line.charAt(i))){
                if(open.isEmpty()){
                  balanced = false;
                  break;
                } else {
                    if (open.poll() != braketsMap.get(line.charAt(i))){
                        balanced = false;
                        break;
                    }
                }
            }
        }
        if (!open.isEmpty()){
            balanced = false;
        }
        if (balanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
