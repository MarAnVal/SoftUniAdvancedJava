import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int n = Integer.parseInt(line.split("\\s+")[0]);
        int m = Integer.parseInt(line.split("\\s+")[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input.nextLine());
            firstSet.add(num);
        }
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(input.nextLine());
            secondSet.add(num);
        }
        for (Integer e : firstSet) {
            if(secondSet.contains(e)){
                System.out.print(e + " ");
            }
        }

    }
}