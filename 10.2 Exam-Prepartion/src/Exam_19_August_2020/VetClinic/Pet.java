package Exam_19_August_2020.VetClinic;

public class Pet {
    //name: String
    private String name;
    //age: int
    private int age;
    //owner: String
    private String owner;

    //The class constructor should receive a name, age, and owner

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOwner() {
        return owner;
    }

//toString() method in the following format:
    //"{name} {age} ({owner})"

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.owner);
    }
}
