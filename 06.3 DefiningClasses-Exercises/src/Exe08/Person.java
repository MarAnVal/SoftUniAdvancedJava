package Exe08;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //"{FirstName} {LastName}" or "day/month/year
    private String name;
    private String birthDay;

    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this.name = "";
        this.birthDay = "";
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Person(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDay);
    }
}
