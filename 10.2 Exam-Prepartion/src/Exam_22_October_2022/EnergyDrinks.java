package Exam_22_October_2022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] caffeine = input.nextLine().split(",\\s+");
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        for (int i = 0; i < caffeine.length; i++) {
            caffeineStack.push(Integer.parseInt(caffeine[i]));
        }
        ArrayDeque<Integer> drinksQue = new ArrayDeque<>();
        String[] drinks = input.nextLine().split(",\\s+");
        for (int i = 0; i < drinks.length; i++) {
            drinksQue.offer(Integer.parseInt(drinks[i]));
        }
        int maxCaffeine = 0;
        while (!(caffeineStack.isEmpty()||drinksQue.isEmpty())){
            int milligrams = caffeineStack.pop();
            int drink = drinksQue.poll();
            if (maxCaffeine + milligrams * drink <= 300){
                //If the sum of the caffeine in the drink and the caffeine that Stamat
                // drank doesn't exceed 300 milligrams, remove both the milligrams of
                // caffeinе and the drink from their sequences.
                // Also, add the caffeine to Stamat's total caffeine.
                maxCaffeine += milligrams * drink;
            } else {
                //If Stamat is about to exceed his maximum caffeine per night,
                // do not add the caffeine to Stamat’s total caffeine.
                // Remove the milligrams of caffeinе and move the drink to the end of the sequence.
                // Also, reduce the current caffeine that Stamat has taken by 30
                // (Note: Stamat's caffeine cannot go below 0).
                drinksQue.offer(drink);
                maxCaffeine -= 30;
                if (maxCaffeine < 0){
                    maxCaffeine = 0;
                }
            }

        }
        if (drinksQue.isEmpty()){
            //If Stamat has drunk all the energy drinks, print:
            //"At least Stamat wasn't exceeding the maximum caffeine."
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            //If Stamat hasn't drunk all the energy drinks, print
            // the remaining ones separated by a comma and a space ", ":
            //"Drinks left: { remaining drinks separated by ", " }"
            System.out.print("Drinks left: ");
            while(!drinksQue.isEmpty()) {
                if(drinksQue.size() == 1){
                    System.out.print(drinksQue.poll());
                } else {
                    System.out.print(drinksQue.poll() + ", ");
                }
            }
            System.out.println();
        }
        //On the next line, print:
        //"Stamat is going to sleep with { current caffeine } mg caffeine."
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", maxCaffeine);
    }
}
