package Exe06;

import java.util.List;

public class Trainer {
    //The trainer has a name, a number of badges, and a collection of pokemon
    //every Trainer starts with 0 badges.
    private String name;
    private int badges;
    private List<Pokemon> collection;

    public Trainer(String name, List<Pokemon> collection) {
        this.name = name;
        this.badges = 0;
        this.collection = collection;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void setCollection(List<Pokemon> collection) {
        this.collection = collection;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getCollection() {
        return collection;
    }

    @Override
    public String toString() {
        //"{TrainerName} {Badges} {NumberOfPokemon}".
        return String.format("%s %d %d", this.name, this.badges, this.collection.size());
    }
}
