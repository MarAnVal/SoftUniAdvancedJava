package Froggy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line = input.nextLine().split(",\\s+");
        Lake lake = new Lake(line);
        String end = input.nextLine();
        StringBuilder result = new StringBuilder();

        for (Integer integer : lake) {
            result.append(integer + ", ");
        }
        result.delete(result.length() - 2, result.length());
        System.out.println(result);
    }
}
