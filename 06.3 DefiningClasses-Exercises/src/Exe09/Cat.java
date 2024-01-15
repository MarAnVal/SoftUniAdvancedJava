package Exe09;

public class Cat {
    private String breed;
    private String name;
    private double specific;

    public Cat(String breed, String name, double specific) {
        this.breed = breed;
        this.name = name;
        this.specific = specific;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        //Cymric Tom 28.00
        return String.format("%s %s %.2f", this.breed, this.name, this.specific);
    }
}
