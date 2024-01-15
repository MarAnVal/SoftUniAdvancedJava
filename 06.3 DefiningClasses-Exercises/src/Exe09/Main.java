package Exe09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();
        String line = input.nextLine();
        while (!line.equals("End")) {
            String breed = line.split("\\s+")[0];
            String name = line.split("\\s+")[1];
            double specific = Double.parseDouble(line.split("\\s+")[2]);
            cats.add(new Cat(breed, name, specific));

            line = input.nextLine();
        }
        line = input.nextLine();
        for (int i = 0; i < cats.size(); i++) {
            if(cats.get(i).getName().equals(line)){
                System.out.println(cats.get(i).toString());
                break;
            }
        }
    }

}
