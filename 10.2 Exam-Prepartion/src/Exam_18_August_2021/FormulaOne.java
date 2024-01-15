package Exam_18_August_2021;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int commandCount = Integer.parseInt(input.nextLine());
        char[][] field = new char[n][n];
        int carI = 0;
        int carJ = 0;
//        for (int i = 0; i < n; i++) {
//            field[i] = input.nextLine().toCharArray();
//        }
        for (int i = 0; i < field.length; i++) {
            String line = input.nextLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'P'){
                    carI = i;
                    carJ = j;
                }
                field[i][j] = line.charAt(j);
            }
        }
        field[carI][carJ] = '.';
        boolean finish = false;
        boolean move = true;
        String command = "";
        while (commandCount > 0 || !move) {
            if (move) {
                command = input.nextLine();
                commandCount--;
            } else {
                move = true;
            }
            switch (command) {
                //up, down, left or right
                case "up":
                    if (carI - 1 < 0) {
                        carI = n - 1;
                    } else {
                        carI--;
                    }
                    break;
                case "down":
                    if (carI + 1 > n -1) {
                        carI = 0;
                    } else {
                        carI++;
                    }
                    break;
                case "left":
                    if (carJ - 1 < 0) {
                        carJ = n - 1;
                    } else {
                        carJ--;
                    }
                    break;
                case "right":
                    if (carJ + 1 > n -1) {
                        carJ = 0;
                    } else {
                        carJ++;
                    }
                    break;
            }
            if (field[carI][carJ] == 'F') {
                finish = true;
                break;
            } else if (field[carI][carJ] == 'B') {
                move = false;
            } else if (field[carI][carJ] == 'T') {
                switch (command) {
                    //redo up, down, left or right
                    case "up":
                        command = "down";
                        break;
                    case "down":
                        command = "up";
                        break;
                    case "left":
                        command = "right";
                        break;
                    case "right":
                        command = "left";
                        break;
                }
                move = false;
            }
        }
        if (finish) {
            System.out.print("Well done, the player won first place!");
        } else {
            System.out.print("Oh no, the player got lost on the track!");
        }
        field[carI][carJ] = 'P';
        for (int k = 0; k < field.length; k++) {
            System.out.println();
            for (int j = 0; j < field[k].length; j++) {
                System.out.print(field[k][j]);
            }
        }
    }
}
