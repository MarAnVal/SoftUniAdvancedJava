package Exam_19_February_2022;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int startWi = -1;
        int startWj = -1;
        int startBi = -1;
        int startBj = -1;
        for (int i = 0; i < 8; i++) {
            String[] line = input.nextLine().split("");
            for (int j = 0; j < 8; j++) {
                if (line[j].equals("w")) {
                    startWi = i;
                    startWj = j;
                } else if (line[j].equals("b")) {
                    startBi = i;
                    startBj = j;
                }
            }
        }
        String color = "";
        String coordinates = "";
        boolean catched = false;
        if (Math.abs(startWj - startBj) > 1 || startWi <= startBi) {
            //no catches
            int movesW = startWi;
            int movesB = Math.abs(7 - startBi);
            if (Integer.compare(movesW, movesB) > 0) {
                color = "Black";
                coordinates = String.format("%c%d", (char) (97 + startBj), 1);
            } else {
                color = "White";
                coordinates = String.format("%c%d", (char) (97 + startWj), 8);
            }

        } else {
            //catches
            catched = true;
            int distance = startWi - startBi - 1;
            if (distance % 2 == 0) {
                startWi -= distance / 2;
                startWi -= 1;
                startWj = startBj;
                color = "White";
                coordinates = String.format("%c%d", (char) (97 + startWj), Math.abs(8 - startWi));
            } else {
                startBi += distance / 2;
                startBi += 1;
                startBj = startWj;
                color = "Black";
                coordinates = String.format("%c%d", (char) (97 + startBj), Math.abs(8 - startBi));
            }
        }
        if (catched) {
            // "Game over! {White/Black} capture on {coordinates}."
            System.out.printf("Game over! %s capture on %s.%n", color, coordinates);
        } else {
            //"Game over! {White/Black} pawn is promoted to a queen at {coordinates}."
            System.out.printf("Game over! %s pawn is promoted to a queen at %s.", color, coordinates);
        }

    }
}
