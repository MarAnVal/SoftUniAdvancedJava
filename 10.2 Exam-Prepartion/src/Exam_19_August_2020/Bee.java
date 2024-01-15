package Exam_19_August_2020;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        //"B" "f" "O" "."
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int beeI = -1;
        int beeJ = -1;
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (line[j] == 'B') {
                    field[i][j] = '.';
                    beeI = i;
                    beeJ = j;
                } else {
                    field[i][j] = line[j];
                }
            }
        }
        String command = input.nextLine();
        int flowers = 0;
        while (!command.equals("End")) {
            boolean bonus = false;
            switch (command) {
                case "up":
                    beeI--;
                    break;
                case "down":
                    beeI++;
                    break;
                case "left":
                    beeJ--;
                    break;
                case "right":
                    beeJ++;
                    break;
            }
            if (beeI > -1 && beeI < n && beeJ > -1 && beeJ < n) {
                if (field[beeI][beeJ] == 'f') {
                    flowers++;
                    field[beeI][beeJ] = '.';
                } else if (field[beeI][beeJ] == 'O'){
                    bonus = true;
                    field[beeI][beeJ] = '.';
                }
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            if (!bonus) {
                command = input.nextLine();
            }
        }
        if(flowers>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }
        if(beeI>-1&&beeI<n&&beeJ>-1&&beeJ<n){
            field[beeI][beeJ] = 'B';
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
