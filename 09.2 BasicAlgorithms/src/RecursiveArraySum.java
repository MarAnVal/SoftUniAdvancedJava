import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = sum(arr);
        System.out.println(sum);
    }
    public static int sum(List<Integer> arr){
        int sum = 0;
        if(arr.size() == 1){
            return sum = arr.get(0);
        } else {
            int element = arr.get(0);
            arr.remove(0);
            return sum = element + sum(arr);
        }
    }
}
