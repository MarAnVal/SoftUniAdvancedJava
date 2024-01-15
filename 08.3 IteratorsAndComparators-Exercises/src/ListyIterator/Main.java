package ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ListyIterator listyIterator = new ListyIterator();
        while (!line.equals("END")){
            List<String> parameters = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());
            String command = parameters.get(0);
            parameters.remove(0);
            switch (command){
                case "Create":
                       listyIterator.getElements().addAll(parameters);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try{
                        listyIterator.print();
                    } catch (IllegalStateException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }

            line = input.nextLine();
        }
    }
}
