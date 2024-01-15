package Exam_13_April_2022.EasterBasket;

public class Egg {
    //color: String
    //strength: int
    //shape: String
    private String color;
    private int strength;
    private String shape;

    //constructor should receive color, strength and shape.
    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    //toString() : "{color} egg, with {strength} strength and {shape} shape."
    @Override
    public String toString() {
        return String.format("%s egg, with %d strength and %s shape.", this.color, this.strength, this.shape);
    }
}
