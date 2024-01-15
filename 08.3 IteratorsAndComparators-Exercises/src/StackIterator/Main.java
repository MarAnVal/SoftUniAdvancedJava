package StackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        StackIterator stack = new StackIterator();
        while(!line.equals("END")){
            line = line.replaceAll(",", "");
            List<String> elements = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());
            String command = elements.get(0);
            elements.remove(0);

            switch (command){
                case "Push":
                    stack.push(elements.toArray(new String[0]));
                    break;
                case "Pop":
                    try{
                        stack.pop();
                    } catch (IllegalStateException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            line = input.nextLine();
        }
        System.out.print(stack.toString());
        System.out.print(stack.toString());
    }
}
