package Exam_15_December_2021;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line of input, you will receive e – the energy Paris has.
        int energy = Integer.parseInt(input.nextLine());
        //On the second line of input, you will receive n – the number of rows the field of Sparta will consist of
        //range: [5-20].
        int n = Integer.parseInt(input.nextLine());
        int startI = 0;
        int startJ = 0;
        char[][] field = new char[n][];
        //On the next n lines, you will receive how each row looks.
        for (int i = 0; i < field.length; i++) {
            field[i] = input.nextLine().toCharArray();

        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'P') {
                    startI = i;
                    startJ = j;
                }
            }
        }
        //Then, until Paris dies, or reaches Helen, you will receive a move command and spawn row and column.

        boolean helenFound = false;
        while (energy > 0 && !helenFound) {
            String[] commandLine = input.nextLine().split("\\s+");
            String command = commandLine[0];
            int spawnI = Integer.parseInt(commandLine[1]);
            int spawnJ = Integer.parseInt(commandLine[2]);
            energy -= 1;
            field[spawnI][spawnJ] = 'S';
            field[startI][startJ] = '-';
            switch (command) {
                //"up", "down", "left", "right"
                case "up":
                    if (startI - 1 >= 0) {
                        startI -= 1;
                    }
                    break;
                case "down":
                    if (startI + 1 < n) {
                        startI += 1;
                    }
                    break;
                case "left":
                    if (startJ - 1 >= 0) {
                        startJ -= 1;
                    }
                    break;
                case "right":
                    if (startJ + 1 < n) {
                        startJ += 1;
                    }
                    break;
            }

            if (field[startI][startJ] == 'H') {
                helenFound = true;
                field[startI][startJ] = '-';
            } else {
                if (field[startI][startJ] == 'S') {
                    energy -= 2;
                    field[startI][startJ] = '-';
                }
                if (energy <= 0) {
                    field[startI][startJ] = 'X';
                }
            }
        }
        //If Paris is running out of energy, print "Paris died at {row};{col}."
        if (!helenFound) {
            System.out.printf("Paris died at %d;%d.", startI, startJ);
        } else {
            //If Helen is abducted, print "Paris has successfully abducted Helen! Energy left: {energy}"
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d", energy);
        }
        System.out.println();
        //Then, in all cases, print the final state of the field on the console.
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }


    }

}
