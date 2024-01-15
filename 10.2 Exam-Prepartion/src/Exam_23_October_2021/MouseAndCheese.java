package Exam_23_October_2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will be given an integer n for the size
        int n = Integer.parseInt(input.nextLine());
        //On the next n lines, you will receive the rows
        char[][] field = new char[n][];
        int mouseI = -1;
        int mouseJ = -1;
        for (int i = 0; i < field.length; i++) {
            field[i] = input.next().toCharArray();
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'M') {
                    field[i][j] = '-';
                    mouseI = i;
                    mouseJ = j;
                }
            }
        }
        //The mouse will be placed in a random position, marked with the letter 'M'
        //there will be cheese, marked with 'c'
        //There may also be a bonus. It will be marked with the letter - 'B'
        //All of the empty positions will be marked with '-'.
        boolean out = false;
        int eaten = 0;
        String command = input.next();
        while (!command.equals("end")) {

            switch (command) {
                //Each turn, you will be given a command: "up", "down", "left", "right", "end".
                case "up":
                    mouseI--;
                    break;
                case "down":
                    mouseI++;
                    break;
                case "left":
                    mouseJ--;
                    break;
                case "right":
                    mouseJ++;
                    break;
            }
            if (!isOut(mouseI, mouseJ, n)) {
                out = true;
                break;
            } else {
                //there will be cheese, marked with 'c'
                if (field[mouseI][mouseJ] == 'c') {
                    field[mouseI][mouseJ] = '-';
                    eaten++;
                } else if (field[mouseI][mouseJ] == 'B') {
                    //There may also be a bonus. It will be marked with the letter - 'B'
                    field[mouseI][mouseJ] = '-';
                    continue;
                }
            }
            command = input.next();
        }
        StringBuilder text = new StringBuilder();
        if (out) {
            text.append("Where is the mouse?");
            text.append(System.lineSeparator());
        }
        if (eaten < 5) {
            text.append(String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - eaten));
        } else {
            text.append(String.format("Great job, the mouse is fed %d cheeses!", eaten));
        }
        for (int i = 0; i < field.length; i++) {
            text.append(System.lineSeparator());
            for (int j = 0; j < field[i].length; j++) {
                if (i == mouseI && j == mouseJ) {
                    text.append("M");
                } else {
                    text.append(field[i][j]);
                }
            }
        }
        System.out.println(text);
    }

    public static boolean isOut(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}
