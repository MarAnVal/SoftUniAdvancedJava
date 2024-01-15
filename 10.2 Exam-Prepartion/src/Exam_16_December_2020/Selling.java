package Exam_16_December_2020;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[][] field = new int[n][n];
        int startI = -1;
        int startJ = -1;
        int o1I = -1;
        int o1J = -1;
        int o2I = -1;
        int o2J = -1;
        //"S" - your position
        //"O" - teleport; will be 0 or 2 => move to the 2nd one and both turn "-"
        //"-" - empty
        //0-9 - digits (clients) => collect the int to sum and turn to "-"
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (Character.isDigit(line[j])) {
                    field[i][j] = (int) line[j] - 48;
                } else {
                    if (line[j] == 'S') {
                        startI = i;
                        startJ = j;
                    } else if (line[j] == 'O') {
                        if (o1I > -1 && o1J > -1) {
                            o2I = i;
                            o2J = j;
                        } else {
                            o1I = i;
                            o1J = j;
                        }
                    }
                }
            }
        }
        int money = 0;
        while (true) {
            String command = input.nextLine();
            switch (command) {
                //command "up" "down" "left" "right"
                case "up":
                    startI--;
                    break;
                case "down":
                    startI++;
                    break;
                case "left":
                    startJ--;
                    break;
                case "right":
                    startJ++;
                    break;
            }
            if (startI > -1 && startI < n && startJ > -1 && startJ < n) {
                //"O" - teleport; will be 0 or 2 => move to the 2nd one and both turn "-"
                if ((startI == o1I && startJ == o1J) || (startI == o2I && startJ == o2J)){
                    if (startI == o1I && startJ == o1J){
                        startI = o2I;
                        startJ = o2J;
                    } else {
                        startI = o1I;
                        startJ = o1J;
                    }
                    o1I = -1;
                    o1J = -1;
                    o2I = -1;
                    o2J = -1;
                } else {
                    //0-9 - digits (clients) => collect the int to sum and turn to "-"
                    money += field[startI][startJ];
                    field[startI][startJ] = 0;
                    if(money >= 50){
                        //if u get sum >= 50 program stops; print "Good news! you succeeded in collecting enough money!"
                        System.out.println("Good news! You succeeded in collecting enough money!");
                        break;
                    }
                }
            } else {
                //if given invalid move program stops; print "Bad news, you are out of the bakery."
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
        }
        //print "Money: {money}"
        System.out.printf("Money: %d%n", money);
        //print matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (startI == i && startJ == j){
                    System.out.print("S");
                } else if ((o1I == i && o1J == j) || (o2I == i && o2J==j)){
                    System.out.print("O");
                } else if (field[i][j] == 0){
                    System.out.print("-");
                } else {
                    System.out.print(field[i][j]);
                }
            }
            System.out.println();
        }

    }
}
