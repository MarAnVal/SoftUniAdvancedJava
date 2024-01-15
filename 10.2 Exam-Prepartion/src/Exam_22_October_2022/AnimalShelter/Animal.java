package Exam_22_October_2022.AnimalShelter;

public class Animal {
    //class Animal with the following fields:
    //name: String
    //age: int
    //caretaker: String
    private String name;
    private int age;
    private String caretaker;
    //The class constructor should receive a name, age and caretaker.

    public Animal(String name, int age, String caretaker) {
        this.name = name;
        this.age = age;
        this.caretaker = caretaker;
    }

    //You need to create the appropriate getters and setters.

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

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    //The class should override the toString() method in the following format:
    //"{name} {age} ({caretaker})"

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.caretaker);
    }
}
