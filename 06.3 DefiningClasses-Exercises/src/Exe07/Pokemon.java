package Exe07;

public class Pokemon {
    //"{Name} pokemon {pokemonName} {pokemonType}"
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%n%s %s", this.name, this.type);
    }
}
