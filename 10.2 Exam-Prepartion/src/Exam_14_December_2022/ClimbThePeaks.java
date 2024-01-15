package Exam_14_December_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClimbThePeaks {
    public static void main(String[] args) {
        List<Integer> peaksDifficulty = new ArrayList<>();
        peaksDifficulty.add(80);
        peaksDifficulty.add(90);
        peaksDifficulty.add(100);
        peaksDifficulty.add(60);
        peaksDifficulty.add(70);
        List<String> peaksNames = new ArrayList<>();
        peaksNames.add("Vihren");
        peaksNames.add("Kutelo");
        peaksNames.add("Banski Suhodol");
        peaksNames.add("Polezhan");
        peaksNames.add("Kamenitza");
        Scanner input = new Scanner(System.in);
        List<Integer> dailyPortion = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> dailyStamina = Arrays.stream(input.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int done = 0;
        for (int i = 0, j = dailyPortion.size() - 1; i < dailyStamina.size() || j >= 0; i++, j--) {
            if (peaksDifficulty.isEmpty()) {
                break;
            }
            int daily = dailyPortion.get(j) + dailyStamina.get(i);
            if (daily >= peaksDifficulty.get(0)) {
                peaksDifficulty.remove(0);
                done++;
            }
        }
        if (peaksDifficulty.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");

        }
        if(done > 0){
            System.out.println("Conquered peaks:");
            for (int i = 0; i < done; i++) {
                System.out.println(peaksNames.get(i));
            }
        }


    }
}
