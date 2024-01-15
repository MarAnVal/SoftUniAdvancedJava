package Exam_25_June_2022;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] commandArr = input.nextLine().split(",");
        boolean[][] house = new boolean[n][n];
        boolean[][] police = new boolean[n][n];
        int stolen = 0;
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("$")) {
                    house[i][j] = true;
                }
                if (line[j].equals("P")) {
                    police[i][j] = true;
                }
                if (line[j].equals("D")) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        for (int i = 0; i < commandArr.length; i++) {
            String command = commandArr[i];
            switch (command) {
                //up, down, left or right.
                case "up":
                    if (isItValidCell(startI - 1, startJ, n)) {
                        startI -= 1;
                    }
                    break;
                case "down":
                    if (isItValidCell(startI + 1, startJ, n)) {
                        startI += 1;
                    }
                    break;
                case "left":
                    if (isItValidCell(startI, startJ - 1, n)) {
                        startJ -= 1;
                    }
                    break;
                case "right":
                    if (isItValidCell(startI, startJ + 1, n)) {
                        startJ +=1;
                    }
                    break;
            }
            if (isCatch(startI, startJ, police, stolen)) {
                printMatrix(startI, startJ, house, police);
                return;
            }
            stolen += isHouse(startI, startJ, house);
        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolen);
        printMatrix(startI, startJ, house, police);
    }

    public static boolean isItValidCell(int i, int j, int n) {
        if (!(i > -1 && i < n && j > -1 && j < n)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return false;
        }
        return true;
    }

    public static boolean isCatch(int i, int j, boolean[][] police, Integer stolen) {
        if (police[i][j]) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolen);
            return true;
        } else
            return false;
    }

    public static int isHouse(int i, int j, boolean[][] house) {
        if (house[i][j]) {
            int money = i*j;
            System.out.printf("You successfully stole %d$.%n", money);
            house[i][j] = false;
            return money;
        }
        return 0;
    }

    public static void printMatrix(int i, int j, boolean[][] house, boolean[][] police) {
        String[][] print = new String[house.length][house.length];
        for (int k = 0; k < house.length; k++) {
            for (int l = 0; l < house[i].length; l++) {
                if (k == i && l == j) {
                    if (police[k][l]) {
                        print[k][l] = "#";
                    } else {
                        print[k][l] = "D";
                    }
                } else if (house[k][l]) {
                    print[k][l] = "$";
                } else if (police[k][l]) {
                    print[k][l] = "P";
                } else {
                    print[k][l] = "+";
                }
            }

        }
        for (int k = 0; k < print.length; k++) {
            System.out.println(String.join(" ", print[k]));
        }
    }

}
