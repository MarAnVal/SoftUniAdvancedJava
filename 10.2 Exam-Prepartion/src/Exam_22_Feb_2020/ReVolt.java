package Exam_22_Feb_2020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int commandCount = Integer.parseInt(input.nextLine());
        char[][] field = new char[n][n];
        int startI = -1;
        int startJ = -1;
        //"f" - player
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (line[j] == 'f') {
                    startI = i;
                    startJ = j;
                    field[i][j] = '-';
                } else {
                    field[i][j] = line[j];
                }
            }
        }
        boolean extra = false;
        String command = "";
        boolean lose = true;
        while (commandCount > 0) {
            if (extra) {
                extra = false;
            } else {
                command = input.nextLine();
                commandCount--;
            }
            //if u go out u go on opposite side (no invalid moves)
            switch (command) {
                case "up":
                    startI--;
                    if (startI < 0) {
                        startI = n - 1;
                    }
                    break;
                case "down":
                    startI++;
                    if (startI > n - 1) {
                        startI = 0;
                    }
                    break;
                case "left":
                    startJ--;
                    if (startJ < 0) {
                        startJ = n - 1;
                    }
                    break;
                case "right":
                    startJ++;
                    if (startJ > n - 1) {
                        startJ = 0;
                    }
                    break;
            }
            //"-" - empty
            //"F" - finish end of program; print "Player won!"
            if (field[startI][startJ] == 'F') {
                System.out.println("Player won!");
                lose = false;
                break;
            } else if (field[startI][startJ] == 'B') {
                //"B" - bonus + same move
                extra = true;
            } else if (field[startI][startJ] == 'T') {
                //"T" - trap - same move (back from where came)
                extra = true;
                switch (command) {
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
            }
        }
        if (lose) {
            //if commands end and not reached "F" end the program end print "Player lost"
            System.out.println("Player lost!");
        }
        //Print matrix; if reached "F" replace it wit "f"; print also the player position "f"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (startI == i && startJ == j){
                    System.out.print("f");
                } else {
                    System.out.print(field[i][j]);
                }
            }
            System.out.println();
        }
    }
}
