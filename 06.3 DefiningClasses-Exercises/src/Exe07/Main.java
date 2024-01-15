package Exe07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Map<String, Person> nameMap = new HashMap<>();
        while (!line.equals("End")) {
            String name = line.split("\\s+")[0];
            String command = line.split("\\s+")[1];
            switch (command) {
                case "company":
                    //"{Name} company {companyName} {department} {salary}"
                    String companyName = line.split("\\s+")[2];
                    String department = line.split("\\s+")[3];
                    double salary = Double.parseDouble(line.split("\\s+")[4]);
                    Company company = new Company(companyName, department, salary);
                    nameMap.putIfAbsent(name, new Person(name));
                    Person personCompany = nameMap.get(name);
                    personCompany.setCompany(company);
                    break;
                case "pokemon":
                    //"{Name} pokemon {pokemonName} {pokemonType}"
                    String pokemonName = line.split("\\s+")[2];
                    String pokemonType = line.split("\\s+")[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    nameMap.putIfAbsent(name, new Person(name));
                    Person personPokemon = nameMap.get(name);
                    personPokemon.getPokemon().add(pokemon);
                    break;
                case "parents":
                    //"{Name} parents {parentName} {parentBirthday}"
                    String parentName = line.split("\\s+")[2];
                    String parentBirthDay = line.split("\\s+")[3];
                    Parents parents = new Parents(parentName, parentBirthDay);
                    nameMap.putIfAbsent(name, new Person(name));
                    Person personParents = nameMap.get(name);
                    personParents.getParents().add(parents);
                    break;
                case "children":
                    //"{Name} children {childName} {childBirthday}"
                    String childrenName = line.split("\\s+")[2];
                    String childrenBirthDay = line.split("\\s+")[3];
                    Children children = new Children(childrenName, childrenBirthDay);
                    nameMap.putIfAbsent(name, new Person(name));
                    Person personChildren = nameMap.get(name);
                    personChildren.getChildren().add(children);
                    break;
                case "car":
                    //"{Name} car {carModel} {carSpeed}"
                    String model = line.split("\\s+")[2];
                    int speed = Integer.parseInt(line.split("\\s+")[3]);
                    Car car = new Car(model, speed);
                    nameMap.putIfAbsent(name, new Person(name));
                    Person personCar = nameMap.get(name);
                    personCar.setCar(car);
                    break;
            }
            line = input.nextLine();
        }
        String command = input.nextLine();
        System.out.println(nameMap.get(command).toString());
    }
}