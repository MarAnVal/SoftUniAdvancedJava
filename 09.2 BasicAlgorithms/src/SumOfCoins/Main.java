import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        // TODO
        LinkedHashMap<Integer, Integer> usedCoins = new LinkedHashMap<>();
        while (targetSum > 0) {
            int currentCoin = 0;
            for (int i = 0; i < coins.length; i++) {
                if (targetSum - coins[i] >= 0 && targetSum - coins[i] < targetSum - currentCoin) {
                    currentCoin = coins[i];
                }
            }
            if (currentCoin == 0) {
                System.out.println("Error");
                usedCoins.clear();
                return usedCoins;
            } else {
                targetSum -= currentCoin;
                usedCoins.putIfAbsent(currentCoin, 0);
                usedCoins.put(currentCoin, usedCoins.get(currentCoin) + 1);
            }
        }
        return usedCoins;
    }
}