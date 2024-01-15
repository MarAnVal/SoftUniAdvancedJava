
import java.util.*;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playersHP = 18500;
        double heiganHP = 3000000.0;
        int playerI = 7;
        int playerJ = 7;
        String lastSpell = "";
        boolean cloud = false;

        double playersDamage = Double.parseDouble(input.nextLine());
        while (playersHP > 0) {
            heiganHP -= playersDamage;

            if (cloud) {
                playersHP -= 3500;
                cloud = false;
                lastSpell = "Plague Cloud";
                if (playersHP <= 0) {
                    break;
                }
            }
            if (heiganHP <= 0) {
                break;
            }

            String hit = input.nextLine();
            String spell = hit.split("\\s+")[0];
            int spellI = Integer.parseInt(hit.split("\\s+")[1]);
            int spellJ = Integer.parseInt(hit.split("\\s+")[2]);

            boolean[][] chamber = new boolean[15][15];
            for (int i = spellI - 1; i <= spellI + 1; i++) {
                if (isIndexValid(i)) {
                    for (int j = spellJ - 1; j <= spellJ + 1; j++) {
                        if (isIndexValid(j)) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }
            if (chamber[playerI][playerJ]) {
                if (isCellValid(playerI - 1, playerJ, chamber)) {
                    playerI--;
                } else if (isCellValid(playerI, playerJ + 1, chamber)) {
                    playerJ++;
                } else if (isCellValid(playerI + 1, playerJ, chamber)) {
                    playerI++;
                } else if (isCellValid(playerI, playerJ - 1, chamber)) {
                    playerJ--;
                }

                if (chamber[playerI][playerJ]) {
                    switch (spell) {
                        case "Cloud":
                            playersHP -= 3500;
                            cloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playersHP -= 6000;
                            lastSpell = spell;
                            break;
                    }
                }
            }
        }

        if (heiganHP > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playersHP > 0) {
            System.out.printf("Player: %d%n", playersHP);
        } else {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }
        System.out.printf("Final position: %d, %d%n", playerI, playerJ);
    }

    public static boolean isIndexValid(int i) {
        return i >= 0 && i < 15;
    }

    public static boolean isCellValid(int i, int j, boolean[][] chamber) {
        if (isIndexValid(i) && isIndexValid(j)) {
            return !chamber[i][j];
        } else return false;

    }
}
