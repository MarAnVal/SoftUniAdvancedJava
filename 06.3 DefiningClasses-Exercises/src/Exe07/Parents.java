package Exe07;

public class Parents {
    //"{Name} parents {parentName} {parentBirthday}"
    private String name;
    private String birthDay;

    public Parents(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("%n%s %s", this.name, this.birthDay);
    }
}
