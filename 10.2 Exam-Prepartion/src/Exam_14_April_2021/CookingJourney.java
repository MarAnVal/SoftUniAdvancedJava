package Exam_14_April_2021;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //integer n for the size of the pastry shop with a square shape.
        int n = Integer.parseInt(input.nextLine());
        int[][] shop = new int[n][n];
        int startI = -1;
        int startJ = -1;
        int p1I = -1;
        int p1J = -1;
        int p2I = -1;
        int p2J = -1;
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (Character.isDigit(line[j])) {
                    //there will be clients, marked with a single digit
                    shop[i][j] = (int) line[j] - 48;
                } else {
                    //empty positions will be marked with '-'
                    if (line[j] == 'P') {
                        //pillars will be either 0 or 2 and they are marked with the letter - 'P'
                        if (p1I == -1 && p1J == -1) {
                            p1I = i;
                            p1J = j;
                        } else {
                            p2I = i;
                            p2J = j;
                        }
                    } else if (line[j] == 'S') {
                        //will be placed in a random position, marked with the letter 'S'
                        startI = i;
                        startJ = j;
                    }
                }
            }
        }
        int dolars = 0;
        //need at least 50 dollars to end program
        while (dolars < 50) {
            //will be given commands for your movement. Move commands will be: "up", "down", "left", "right"
            String command = input.nextLine();
            switch (command) {
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
                //move to a pillar, you move on to the position of the other pillar and then both pillars disappear
                if (startI == p1I && startJ == p1J) {
                    startI = p2I;
                    startJ = p2J;
                    p1I = -1;
                    p1J = -1;
                    p2I = -1;
                    p2J = -1;
                } else if (startI == p2I && startJ == p2J) {
                    startI = p1I;
                    startJ = p1J;
                    p1I = -1;
                    p1J = -1;
                    p2I = -1;
                    p2J = -1;
                } else {
                    //move to a client, you collect the price equal to the digit there and the client disappears
                    dolars+= shop[startI][startJ];
                    shop[startI][startJ] = 0;
                }
            } else {
                startI = -1;
                startJ = -1;
                break;
                //you go out of the pastry shop, you disappear; program ends
            }
        }
        if(dolars>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.printf("Money: %d", dolars);
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==p1I&&j==p1J || i==p2I&&j==p2J){
                    System.out.print("P");
                }else if (i== startI && j == startJ){
                    System.out.print("S");
                } else if (shop[i][j] == 0){
                    System.out.print("-");
                } else {
                    System.out.print(shop[i][j]);
                }
            }
            System.out.println();
        }
    }
}
