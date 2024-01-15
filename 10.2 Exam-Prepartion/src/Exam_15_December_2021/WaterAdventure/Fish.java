package Exam_15_December_2021.WaterAdventure;

public class Fish {
    //name: String
    private String name;
    //color: String
    private String color;
    //fins: int
    private int fins;

    //The constructor of the Fish class should receive a name, color, and fins.

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    //The class should also have the following methods:
    //Getter getName()
    public String getName() {
        return name;
    }
    //Getter getColor()
    public String getColor() {
        return color;
    }
    //Getter getFins()
    public int getFins() {
        return fins;
    }
    //Override toString() method in the format:
    //"Fish: {name}
    //Color: {color}
    //Number of fins: {fins}"
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Fish: %s", this.name));
        text.append(System.lineSeparator());
        text.append(String.format("Color: %s", this.color));
        text.append(System.lineSeparator());
        text.append(String.format("Number of fins: %d", this.fins));
        return text.toString();
    }
}
