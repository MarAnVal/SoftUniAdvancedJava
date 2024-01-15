import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        long factorial = factorial(n);
        System.out.println(factorial);
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
