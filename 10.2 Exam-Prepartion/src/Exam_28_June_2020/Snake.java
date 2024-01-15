package Exam_28_June_2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int snakeI = -1;
        int snakeJ = -1;
        int b1I = -1;
        int b1J = -1;
        int b2I = -1;
        int b2J = -1;
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (line[j] == 'S') {
                    snakeI = i;
                    snakeJ = j;
                    field[i][j] = '.';
                } else {
                    if (line[j] == 'B') {
                        if (b1I == -1 && b1J == -1) {
                            b1I = i;
                            b1J = j;
                        } else {
                            b2I = i;
                            b2J = j;
                        }
                    }
                    field[i][j] = line[j];
                }
            }
        }
        int food = 0;
        while (true) {
            String command = input.nextLine();
            switch (command) {
                case "up":
                    snakeI--;
                    break;
                case "down":
                    snakeI++;
                    break;
                case "left":
                    snakeJ--;
                    break;
                case "right":
                    snakeJ++;
                    break;
            }
            if (snakeI > -1 && snakeI < n && snakeJ > -1 && snakeJ < n) {
                if ((snakeI == b1I && snakeJ == b1J) || (snakeI == b2I && snakeJ == b2J)) {
                    if (snakeI == b1I && snakeJ == b1J) {
                        field[snakeI][snakeJ] = '.';
                        snakeI = b2I;
                        snakeJ = b2J;
                    } else {
                        field[snakeI][snakeJ] = '.';
                        snakeI = b1I;
                        snakeJ = b1J;
                    }
                } else if (field[snakeI][snakeJ] == '*') {
                    food++;
                    if (food >= 10) {
                        field[snakeI][snakeJ] = 'S';
                        System.out.println("You won! You fed the snake.");
                        break;
                    }
                }
                field[snakeI][snakeJ] = '.';
            } else {
                System.out.println("Game over!");
                break;
            }
        }
        System.out.printf("Food eaten: %d%n", food);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
