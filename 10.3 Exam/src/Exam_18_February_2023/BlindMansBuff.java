package Exam_18_February_2023;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dimensions = input.nextLine();
        int n = Integer.parseInt(dimensions.split("\\s+")[0]);
        int m = Integer.parseInt(dimensions.split("\\s+")[1]);
        int startI = -1;
        int startJ = -1;
        String[][] field = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                if (line[j].equals("B")) {
                    startI = i;
                    startJ = j;
                    field[i][j] = "-";
                } else {
                    field[i][j] = line[j];
                }
            }
        }
        //You will be marked with the letter 'B'
        //furniture or other obstacles will be marked with the letter 'O'
        //other players (opponents) will be marked with the letter 'P';will always be three other players
        // empty positions will be marked with '-'
        String command = input.nextLine();
        int moveCount = 0;
        int players = 3;
        //game is over when you manage to touch all other opponents or the given command is "Finish"
        while (!command.equals("Finish")) {
            switch (command) {
                //"up", " down", "right", and "left"
                //If the direction leads you out of the field,
                // you need to stay in position inside the field(do NOT make the move)
                //If you have an obstacle, towards the direction,
                // do NOT make the move and wait for the next command
                case "up":
                    if (startI > 0) {
                        if (!field[startI - 1][startJ].equals("O")) {
                            startI--;
                            moveCount++;
                        }
                    }
                    break;
                case "down":
                    if (startI < m - 1) {
                        if (!field[startI + 1][startJ].equals("O")) {
                            startI++;
                            moveCount++;
                        }
                    }
                    break;
                case "left":
                    if (startJ > 0) {
                        if (!field[startI][startJ - 1].equals("O")) {
                            startJ--;
                            moveCount++;
                        }
                    }
                    break;
                case "right":
                    if (startJ < m - 1) {
                        if (!field[startI][startJ + 1].equals("O")) {
                            startJ++;
                            moveCount++;
                        }
                    }
            }
            //You need to keep track of the count of touched opponents and the moves you’ve made.
            //move not increase if met obstacle or end of filed;
            if (field[startI][startJ].equals("P")) {
                players--;
                field[startI][startJ] = "-";
                if (players <= 0) {
                    break;
                }
            }
            //game is over when you manage to touch all other opponents or the given command is "Finish"
            command = input.nextLine();
        }
        //"Game over!"
        //"Touched opponents: {count} Moves made: {count}"
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", 3 - players, moveCount);
    }
}
