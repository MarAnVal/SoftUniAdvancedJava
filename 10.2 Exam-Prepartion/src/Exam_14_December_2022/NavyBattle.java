package Exam_14_December_2022;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        boolean[][] mines = new boolean[n][n];
        boolean[][] all = new boolean[n][n];
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("*")) {
                    mines[i][j] = true;
                    all[i][j] = true;
                }
                if (line[j].equals("C")) {
                    all[i][j] = true;
                }
                if (line[j].equals("S")) {
                    startJ = j;
                    startI = i;
                }
            }
        }
        int hit = 3;
        int cruiser = 3;
        while (hit != 0 && cruiser != 0) {
            String line = input.nextLine();
            switch (line) {
                case "up":
                    startI--;
                    if (all[startI][startJ]) {
                        if (mines[startI][startJ]) {
                            hit--;
                            mines[startI][startJ] = false;
                            all[startI][startJ] = false;
                        } else {
                            cruiser--;
                            all[startI][startJ] = false;}
                    }
                    break;
                case "down":
                    startI++;
                    if (all[startI][startJ]) {
                        if (mines[startI][startJ]) {
                            hit--;
                            mines[startI][startJ] = false;
                            all[startI][startJ] = false;
                        } else {
                            cruiser--;
                            all[startI][startJ] = false;}
                    }
                    break;
                case "left":
                    startJ--;
                    if (all[startI][startJ]) {
                        if (mines[startI][startJ]) {
                            hit--;
                            mines[startI][startJ] = false;
                            all[startI][startJ] = false;
                        } else {
                            cruiser--;
                            all[startI][startJ] = false;}
                    }
                    break;
                case "right":
                    startJ++;
                    if (all[startI][startJ]) {
                        if (mines[startI][startJ]) {
                            hit--;
                            mines[startI][startJ] = false;
                            all[startI][startJ] = false;
                        } else {
                            cruiser--;
                            all[startI][startJ] = false;}
                    }
                    break;
            }
        }
        if (cruiser == 0){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } if (hit == 0){
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", startI, startJ);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mines[i][j]){
                    System.out.print("*");
                } else if (all[i][j]) {
                    System.out.print("C");
                } else if (i == startI && j == startJ){
                    System.out.print("S");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
