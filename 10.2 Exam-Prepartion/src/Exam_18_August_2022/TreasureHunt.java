package Exam_18_August_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will be given N and M – integers, indicating the field's dimensions
        String[] dimensions = input.nextLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        int startI = -1;
        int startJ = -1;
        boolean[][] treasure = new boolean[n][m];
        boolean[][] field = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("T")) {
                    field[i][j] = true;
                }
                if (line[j].equals("X")) {
                    treasure[i][j] = true;
                }
                if (line[j].equals("Y")) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        String command = input.nextLine();
        List<String> path = new ArrayList<>();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (isValidCell(startI - 1, startJ, n, m)) {
                        if (isValidMove(startI - 1, startJ, field)) {
                            startI -= 1;
                            path.add(command);
                        }
                    }
                    break;
                case "down":
                    if (isValidCell(startI + 1, startJ, n, m)) {
                        if (isValidMove(startI + 1, startJ, field)) {
                            startI += 1;
                            path.add(command);
                        }
                    }
                    break;
                case "right":
                    if (isValidCell(startI, startJ + 1, n, m)) {
                        if (isValidMove(startI, startJ + 1, field)) {
                            startJ += 1;
                            path.add(command);
                        }
                    }
                    break;
                case "left":
                    if (isValidCell(startI, startJ - 1, n, m)) {
                        if (isValidMove(startI, startJ - 1, field)) {
                            startJ -= 1;
                            path.add(command);
                        }
                    }
                    break;
            }
            command = input.nextLine();
        }
        //If you have found the treasure (the last step is on a position marked with 'X')
        // print the following output: "I've found the treasure!".
        if (isValidCell(startI, startJ, n, m) && treasure[startI][startJ]) {
            System.out.println("I've found the treasure!");
            //On the next line, print the correct directions you went
            // to find the treasure (do not include the directions that
            // made you go out of the field or step on a tree).
            // The directions must be separated by a comma and space (", "). It should look like this:
            //"The right path is {direction1}, {direction2}, …".
            System.out.printf("The right path is %s%n", String.join(", ", path));
        } else {
            //If you have not found the treasure, print the following message: "The map is fake!".
            System.out.println("The map is fake!");
        }
    }

    private static boolean isValidCell(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private static boolean isValidMove(int i, int j, boolean[][] field) {
        return !field[i][j];
    }
}
