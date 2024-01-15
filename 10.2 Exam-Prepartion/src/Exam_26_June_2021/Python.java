package Exam_26_June_2021;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        char[][] field = new char[n][];
        int snakeI = -1;
        int snakeJ = -1;
        int food = 0;
        String[] commands = input.nextLine().split(",\\s+");
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 's') {
                    snakeI = i;
                    snakeJ = j;
                }
                if (line[j] == 'f') {
                    food++;
                }
            }
            field[i] = line;
        }
        field[snakeI][snakeJ] = '*';

        boolean dead = false;
        int snakeLength = food + 1;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                //"left", "right", "up", "down"
                case "up":
                    if (snakeI - 1 < 0) {
                        snakeI = n - 1;
                    } else {
                        snakeI--;
                    }
                    break;
                case "down":
                    if (snakeI + 1 > n - 1) {
                        snakeI = 0;
                    } else {
                        snakeI++;
                    }
                    break;
                case "left":
                    if (snakeJ - 1 < 0) {
                        snakeJ = n - 1;
                    } else {
                        snakeJ--;
                    }
                    break;
                case "right":
                    if (snakeJ + 1 > n - 1) {
                        snakeJ = 0;
                    } else {
                        snakeJ++;
                    }
                    break;
            }
            if(field[snakeI][snakeJ] == 'f'){
                food--;
                field[snakeI][snakeJ] = '*';
                if (food < 1){
                    break;
                }
            } else if(field[snakeI][snakeJ] == 'e'){
                dead = true;
                break;
            }
        }
        if (dead){
            System.out.println("You lose! Killed by an enemy!");
        } else if (food > 0){
            System.out.printf("You lose! There is still %d food to be eaten.%n", food);
        } else {
            System.out.printf("You win! Final python length is %d%n", snakeLength);
        }
    }
}

