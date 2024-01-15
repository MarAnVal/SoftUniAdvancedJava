package Exam_22_Feb_2020.Guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    //roster (a collection that stores Player entities)
    private List<Player> roster;
    //name: String
    private String name;
    //capacity: int
    private int capacity;

    //should receive the name and capacity, also it should initialize the roster with a new instance of the collection

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    //Method addPlayer(Player player) - adds an entity to the roster if there is room for it
    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    //Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
    public boolean removePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getName().equals(name)) {
                return this.roster.remove(player);
            }
        }
        return false;
    }

    //Method promotePlayer(String name) - promote (set his rank to "Member")
    // the first player with the given name. If the player is already a "Member", do nothing.
    public void promotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
            }
        }
    }

    //Method demotePlayer(String name)- demote (set his rank to "Trial")
    // the first player with the given name. If the player is already a "Trial",  do nothing.
    public void demotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
            }
        }
    }

    //Method kickPlayersByClass(String clazz) - removes all the players by the given
    // class and returns all removed players from that class as an array
    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kicked = new ArrayList<>();
        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getClazz().equals(clazz)) {
                this.roster.remove(player);
                i--;
                kicked.add(player);
            }
        }
        Player[] out = new Player[kicked.size()];
        for (int i = 0; i < kicked.size(); i++) {
            out[i] = kicked.get(i);
        }
        return out;
    }

    //Method count() - returns the number of players
    public int count() {
        return this.roster.size();
    }
    //Method report() - returns a String in the following format:
    //"Players in the guild: {guildName}:
    //{Player1}
    //{Player2}
    //(…)"
    public String report(){
        StringBuilder text = new StringBuilder();
        text.append(String.format("Players in the guild: %s:", this.name));
        for (int i = 0; i < this.roster.size(); i++) {
            text.append(System.lineSeparator());
            text.append(this.roster.get(i));
        }
        return text.toString();
    }
}
