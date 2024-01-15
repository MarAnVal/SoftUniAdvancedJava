package Exam_13_April_2022;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // n for the size of the armory with a square shape
        int n = Integer.parseInt(input.nextLine());
        //next n lines, you will receive the rows of the armory.
        int startI = -1;
        int startJ = -1;
        int firstMirrorI = -1;
        int firstMirrorJ = -1;
        int secondMirrorI = -1;
        int secondMirrorJ = -1;
        int[][] swords = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("");
            //army officer will be placed in a random position, marked with the letter 'A'.
            //All of the empty positions will be marked with '-'.
            //There may also be mirrors, the count will be either 0 or 2 and they are marked with the letter - 'M'
            //On random positions, there will be swords, marked with a single digit (the price of the sword)
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("A")) {
                    startI = i;
                    startJ = j;
                } else if (line[j].equals("-")) {
                    swords[i][j] = 0;
                } else if (line[j].equals("M")) {
                    if (firstMirrorI == -1 && firstMirrorJ == -1) {
                        firstMirrorI = i;
                        firstMirrorJ = j;
                    } else {
                        secondMirrorI = i;
                        secondMirrorJ = j;
                    }
                    swords[i][j] = -1;
                } else {
                    swords[i][j] = Integer.parseInt(line[j]);
                }

            }
        }
        String command = input.nextLine();
        int gold = 0;
        boolean out = false;
        while (true) {
            //The program ends when the army officer buys blades for at least 65 gold coins,
            // or you guide him out of the armory.
            switch (command) {
                //Move commands will be: "up", "down", "left", "right".
                case "up":
                    startI -= 1;
                    break;
                case "down":
                    startI += 1;
                    break;
                case "left":
                    startJ -= 1;
                    break;
                case "right":
                    startJ += 1;
                    break;
            }
            if (isItValidMove(startI, startJ, n)) {
                // If the army officer moves to a mirror, he teleports on the position of the other mirror,
                // and then both mirrors disappear.
                if (startI == firstMirrorI && startJ == firstMirrorJ) {
                    startI = secondMirrorI;
                    startJ = secondMirrorJ;
                    swords[firstMirrorI][firstMirrorJ] = 0;
                    swords[secondMirrorI][secondMirrorJ] = 0;
                    firstMirrorI = -1;
                    firstMirrorJ = -1;
                    secondMirrorI = -1;
                    secondMirrorJ = -1;
                } else if (startI == secondMirrorI && startJ == secondMirrorJ) {
                    startI = firstMirrorI;
                    startJ = firstMirrorJ;
                    swords[firstMirrorI][firstMirrorJ] = 0;
                    swords[secondMirrorI][secondMirrorJ] = 0;
                    firstMirrorI = -1;
                    firstMirrorJ = -1;
                    secondMirrorI = -1;
                    secondMirrorJ = -1;
                } else {
                    // If the army officer moves to a sword, he buys the sword for
                    // a price equal to the digit there and the sword disappears.
                    gold += boughtSword(startI, startJ, swords);
                }
            } else {
                // If you guide the army officer out of the armory,
                // he leaves with the swords that he has bought
                // and program ends
                out = true;
                break;
            }
            if (gold > 65) {
                break;
            } else {
                command = input.nextLine();
            }
        }
        printMatrix(startI, startJ, swords, gold, out);

        //On the first line:
        //If the army officer leaves the armory, print: "I do not need more swords!"
        //If the army officer fulfills the initial deal, print: "Very nice swords, I will come back for more!"
        //On the second line print the profit you’ve made: "The king paid {amount} gold coins."
        //At the end print the final state of the matrix (armory).
    }

    public static boolean isItValidMove(int startI, int startJ, int n) {
        return startI >= 0 && startI < n && startJ >= 0 && startJ < n;
    }

    public static int boughtSword(int startI, int startJ, int[][] swords) {
        int bought = swords[startI][startJ];
        swords[startI][startJ] = 0;
        return bought;
    }

    public static void printMatrix(int startI, int startJ, int[][] swords, int gold, boolean out) {
        StringBuilder text = new StringBuilder();
        if (out) {
            text.append("I do not need more swords!");
        } else {
            text.append("Very nice swords, I will come back for more!");
        }
        text.append(System.lineSeparator());
        text.append(String.format("The king paid %d gold coins. ", gold));
        for (int i = 0; i < swords.length; i++) {
            text.append(System.lineSeparator());
            for (int j = 0; j < swords[i].length; j++) {
                String element = "";
                if (swords[i][j] < 0) {
                    element = "M";
                } else if (startI == i && startJ == j) {
                    element = "A";
                } else if (swords[i][j] == 0) {
                    element = "-";
                } else {
                    element = String.format("%d", swords[i][j]);
                }
                if (j < swords[i].length - 1) {
                    element = String.format("%s", element);
                } else {
                    element = String.format("%s ", element);
                }
                text.append(element);
            }

        }
        System.out.println(text.toString());
    }
}
