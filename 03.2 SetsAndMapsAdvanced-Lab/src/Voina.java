import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();
        for (int i = 0; i < 20; i++) {
            firstPlayer.add(input.nextInt());
        }
        for (int i = 0; i < 20; i++) {
            secondPlayer.add(input.nextInt());
        }

        int turns = 0;
        while(turns < 50 && firstPlayer.size() > 0 && secondPlayer.size() > 0){
            int firstNum = firstPlayer.iterator().next();
            int secondNum = secondPlayer.iterator().next();
            firstPlayer.remove(firstNum);
            secondPlayer.remove(secondNum);
            if (firstNum > secondNum){
                firstPlayer.add(firstNum);
                firstPlayer.add(secondNum);
            } else if (secondNum > firstNum){
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }
            turns++;
        }
        if(firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        } else if(firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }
}
