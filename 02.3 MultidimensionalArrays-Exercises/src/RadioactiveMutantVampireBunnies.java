
import java.util.*;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int colons = Integer.parseInt(dimensions.split("\\s+")[1]);
        boolean[][] lair = new boolean[rows][colons];
        int playerI = -1;
        int playerJ = -1;
        for (int i = 0; i < rows; i++) {
            String[] rowArr = input.nextLine().split("");
            for (int j = 0; j < colons; j++) {
                if (rowArr[j].equals("B")) {
                    lair[i][j] = true;
                } else if (rowArr[j].equals("P")) {
                    playerI = i;
                    playerJ = j;
                }
            }
        }

        ArrayDeque<String> commandsStack = new ArrayDeque<>();
        String[] line = input.nextLine().split("");
                Collections.addAll(commandsStack, line);
        while (isValidCell(playerI, playerJ, lair)) {
            String command = commandsStack.pop();
            switch (command) {
                case "U":
                    playerI -= 1;
                    break;
                case "D":
                    playerI += 1;
                    break;
                case "L":
                    playerJ -= 1;
                    break;
                case "R":
                    playerJ += 1;
                    break;
            }
            lair = newTurn(lair);

        }
        printLair(lair);
        if (isValid(playerI, playerJ, lair)) {
            System.out.printf("dead: %d %d%n", playerI, playerJ);
        } else {
            System.out.printf("won: %s", lastCell(playerI, playerJ, lair));
        }
    }

    public static void printLair(boolean[][] lair) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                if (lair[i][j]) {
                    System.out.print("B");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static String lastCell(int i, int j, boolean[][] lair) {
        if (i < 0) {
            i = 0;
        } else if (i > lair.length - 1) {
            i = lair.length - 1;
        } else if (j < 0) {
            j = 0;
        } else if (j > lair[i].length - 1) {
            j = lair[i].length - 1;
        }
        return i + " " + j;
    }

    public static boolean isValid(int i, int j, boolean[][] lair) {
        return i >= 0 && i < lair.length && j >= 0 && j < lair[i].length;
    }

    public static boolean isValidCell(int i, int j, boolean[][] lair) {
        if (isValid(i, j, lair)) {
            return !lair[i][j];
        } else {
            return false;
        }
    }

    public static boolean[][] newTurn(boolean[][] lair) {
        boolean[][] buffer = new boolean[lair.length][lair[0].length];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                if (lair[i][j]) {
                    if(isValidCell(i-1, j, buffer)){
                        buffer[i-1][j] = true;
                    }
                    if (isValidCell(i, j + 1, buffer)) {
                        buffer[i][j+1] = true;
                    }
                    if (isValidCell(i + 1, j, buffer)){
                        buffer[i+1][j] = true;
                    }
                    if(isValidCell(i, j-1,buffer)){
                        buffer[i][j-1] = true;
                    }
                    buffer[i][j] = true;
                }
            }
        }
        return buffer;
    }
}
