package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        List<Person> personsList = new ArrayList<>();
        while(!line.equals("END")){
            String name = line.split("\\s+")[0];
            int age = Integer.parseInt(line.split("\\s+")[1]);
            String town = line.split("\\s+")[2];
            Person person = new Person(name, age, town);
            personsList.add(person);
            line = input.nextLine();
        }
        int n = Integer.parseInt(input.nextLine()) - 1;
        Person personToCompare = personsList.get(n);
        int countEqual = 0;
        int countDifferent = 0;
        for (int i = 0; i < personsList.size(); i++) {
            if(personToCompare.compareTo(personsList.get(i)) != 0){
               countDifferent++;
            } else {
                countEqual++;
            }
        }
        if (countEqual > 1){
            System.out.printf("%d %d %d%n", countEqual, countDifferent, personsList.size());
        } else {
        System.out.println("No matches");}
    }
}
