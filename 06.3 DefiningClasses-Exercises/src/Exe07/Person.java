package Exe07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //People's names are unique - there won't be 2 people with the same name,
    // a person can also have only 1 company and car,
    // but can have multiple parents, children,
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemon;

    public Person(String name) {
        this.name = name;
        this.company = new Company("", "", 0.0);
        this.car = new Car("", 0);
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(this.name);
        text.append("\nCompany:");
        text.append(this.company.toString());
        text.append("\nCar:");
        text.append(this.car.toString());
        text.append("\nPokemon:");
        this.pokemon.forEach(e -> text.append(e.toString()));
        text.append("\nParents:");
        this.parents.forEach(e -> text.append(e.toString()));
        text.append("\nChildren:");
        this.children.forEach(e -> text.append(e.toString()));

        return text.toString();
    }
}
