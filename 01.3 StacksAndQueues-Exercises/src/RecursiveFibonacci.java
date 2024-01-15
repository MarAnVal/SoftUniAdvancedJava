import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayDeque<Long> fub = new ArrayDeque<>();
        long f2 = 1L;
        fub.push(1L);
        int n = input.nextInt();


            for (int i = 1; i < n; i++) {
                long f1 = fub.pop();

                long sum = f1 + f2;
                fub.push(f1);
                fub.push(f2);
                f2 = sum;
            }

        System.out.println(f2);
    }
}
