package Exam_17_Dec_2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int presentsCount = Integer.parseInt(input.nextLine());
        int n = Integer.parseInt(input.nextLine());
        int startI = -1;
        int startJ = -1;
        int goodKids = 0;
        String[][] field = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("S")) {
                    //"S" - santa
                    startI = i;
                    startJ = j;
                    field[i][j] = "-";
                } else {
                    if (line[j].equals("V")) {
                        goodKids++;
                    }
                    field[i][j] = line[j];
                }
            }
        }
        String command = input.nextLine();
        //"V" - good kid (give present); mark after with "-"
        //"X" - bad kid(no present); mark after with "-"
        //"C" - cookies (all kids up, down, left, right get present bad or good); mark after with "-"
        //"-" - empty
        int givedPresents = 0;
        while (!command.equals("Christmas morning") && presentsCount > 0) {
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
            if (field[startI][startJ].equals("V")) {
                field[startI][startJ] = "-";
                givedPresents++;
                goodKids--;
                presentsCount--;
            } else if (field[startI][startJ].equals("X")) {
                field[startI][startJ] = "-";
            } else if (field[startI][startJ].equals("C")) {
                if (field[startI - 1][startJ].equals("V")) {
                    field[startI - 1][startJ] = "-";
                    goodKids--;
                    presentsCount--;
                    givedPresents++;
                } else if (field[startI - 1][startJ].equals("X")) {
                    field[startI - 1][startJ] = "-";
                    presentsCount--;
                    givedPresents++;
                }
                if (field[startI + 1][startJ].equals("V")) {
                    field[startI + 1][startJ] = "-";
                    goodKids--;
                    presentsCount--;
                    givedPresents++;
                } else if (field[startI + 1][startJ].equals("X")) {
                    field[startI + 1][startJ] = "-";
                    presentsCount--;
                    givedPresents++;
                }
                if (field[startI][startJ - 1].equals("V")) {
                    field[startI][startJ - 1] = "-";
                    goodKids--;
                    presentsCount--;
                    givedPresents++;
                } else if (field[startI][startJ - 1].equals("X")) {
                    field[startI][startJ - 1] = "-";
                    presentsCount--;
                    givedPresents++;
                }
                if (field[startI][startJ + 1].equals("V")) {
                    field[startI][startJ + 1] = "-";
                    goodKids--;
                    presentsCount--;
                    givedPresents++;
                } else if (field[startI][startJ + 1].equals("X")) {
                    field[startI][startJ + 1] = "-";
                    presentsCount--;
                    givedPresents++;
                }
            }
            if (presentsCount > 0) {
                command = input.nextLine();
            }
        }
        if (presentsCount <= 0) {
            System.out.println("Santa ran out of presents!");
        }
        field[startI][startJ] = "S";
        for (String[] strings : field) {
            System.out.println(String.join(" ", strings));
        }
        if (goodKids > 0) {
            System.out.printf("No presents for %d nice kid/s.%n", goodKids);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", givedPresents);
        }
    }
}
