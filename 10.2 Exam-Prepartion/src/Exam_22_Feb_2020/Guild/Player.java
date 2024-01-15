package Exam_22_Feb_2020.Guild;

public class Player {
    //name: String
    private String name;
    //clazz: String
    private String clazz;
    //rank: String – "Trial" by default
    private String rank;
    //description: String – "n/a" by default
    private String description;

    //constructor should receive the name and clazz

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //toString() method in the following format:
    //"Player {name}: {clazz}
    //Rank: {rank}
    //Description: {description}"

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Player %s: %s", this.name, this.clazz));
        text.append(System.lineSeparator());
        text.append(String.format("Rank: %s", this.rank));
        text.append(System.lineSeparator());
        text.append(String.format("Description: %s", this.description));
        return text.toString();
    }
}
