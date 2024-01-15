package Exe08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        List<String> relations = new ArrayList<>();
        String line = input.nextLine();
        while (!line.equals("End")) {
            if (personList.isEmpty()) {
                //Peter Johnson or 13/12/1993
                Person person;
                if (isSplit(line, "\\s+")) {
                    person = new Person(line, "");
                } else {
                    person = new Person("", line);
                }
                personList.add(person);
            } else {
                //Peter Johnson - George Johnson or George Johnson 1/1/2005
                if (isSplit(line, " - ")) {
                    relations.add(line);
                } else {
                    String name = line.split("\\s+")[0] + " " + line.split("\\s+")[1];
                    String date = line.split("\\s+")[2];
                    boolean added = false;
                    for (int i = 0; i < personList.size(); i++) {
                        Person person = personList.get(i);
                        if (person.getName().equals(name)) {
                            person.setBirthDay(date);
                            added = true;
                            break;
                        } else if (person.getBirthDay().equals(date)) {
                            person.setName(name);
                            added = true;
                            break;
                        }
                    }
                    if (!added) {
                        personList.add(new Person(name, date));
                    }
                }
            }


            line = input.nextLine();
        }
        for (int i = 0; i < relations.size(); i++) {
            String parent = relations.get(i).split(" - ")[0];
            String child = relations.get(i).split(" - ")[1];
            Person personParent = new Person();
            Person personChild = new Person();
            for (int j = 0; j < personList.size(); j++) {
                if(personList.get(j).getName().equals(parent) || personList.get(j).getBirthDay().equals(parent)){
                    personParent = personList.get(j);
                }
                if(personList.get(j).getName().equals(child) || personList.get(j).getBirthDay().equals(child)){
                    personChild = personList.get(j);
                }
            }
            personParent.getChildren().add(personChild);
            personChild.getParents().add(personParent);
        }
        System.out.println(personList.get(0).toString());
        System.out.println("Parents:");
        personList.get(0).getParents().forEach(e -> System.out.println(e.toString()));
        System.out.println("Children:");
        personList.get(0).getChildren().forEach(e -> System.out.println(e.toString()));
    }

    public static boolean isSplit(String text, String regex) {
        return text.split(regex).length > 1;
    }
}
