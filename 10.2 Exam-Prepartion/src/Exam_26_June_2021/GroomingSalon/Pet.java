package Exam_26_June_2021.GroomingSalon;

public class Pet {
    //name: String
    private String name;
    //age: int
    private int age;
    //owner: String
    private String owner;

    //constructor should receive all fields

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    //toString() method in the following format:
    //"{name} {age} - ({owner})"

    @Override
    public String toString() {
        return String.format("%s %d - (%s)", this.name, this.age, this.owner);
    }
}
