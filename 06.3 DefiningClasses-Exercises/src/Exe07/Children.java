package Exe07;

public class Children {
    //"{Name} children {childName} {childBirthday}"
    private String name;
    private String birthDay;

    public Children(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("%n%s %s", this.name, this.birthDay);
    }
}
