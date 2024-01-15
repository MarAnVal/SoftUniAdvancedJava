package Exam_20_February_2021;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] command = input.nextLine().split(",");
        int bombCount = 0;
        int startI = -1;
        int startJ = -1;
        int endI = -1;
        int endJ = -1;
        String[][] field = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("s")) {
                    startI = i;
                    startJ = j;
                } else if (line[j].equals("B")) {
                    bombCount++;
                }
                field[i][j] = line[j];
            }
        }

        for (int i = 0; i < command.length; i++) {
            switch (command[i]) {
                case "up":
                    if (startI > 0) {
                        startI--;
                    }
                    break;
                case "down":
                    if (startI + 1 < n) {
                        startI++;
                    }
                    break;
                case "left":
                    if (startJ > 0) {
                        startJ--;
                    }
                    break;
                case "right":
                    if (startJ + 1 < n) {
                        startJ++;
                    }
                    break;
            }
            if (field[startI][startJ].equals("B")) {
                field[startI][startJ] = "+";
                bombCount--;
                System.out.println("You found a bomb!");
                if (bombCount == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (field[startI][startJ].equals("e")) {
                System.out.printf("END! %d bombs left on the field%n", bombCount);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombCount, startI, startJ);

    }
}
