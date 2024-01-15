package Exam_15_December_2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> males = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).filter(e -> e > 0).collect(Collectors.toList());
        Collections.reverse(males);
        List<Integer> females = Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt).filter(e -> e > 0).collect(Collectors.toList());
        remove25(males);
        remove25(females);
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.get(0);
            males.remove(0);
            int female = females.get(0);
            females.remove(0);
            if (male == female) {
                matches++;
            } else {
                male -= 2;
                males.add(0, male);
                removeZeroAndBelow(males);
                remove25(males);
            }
        }
        StringBuilder text = new StringBuilder();
        //On the first line - print the number of successful matches:
        //"Matches: {matchesCount}"
        text.append(String.format("Matches: %d", matches));
        text.append(System.lineSeparator());
        //On the second line - print all males left:
        //If there are no males: "Males left: none"
        //If there are males: "Males left: {male1}, {male2}, {male3}, (…)"
        text.append("Males left: ");
        if(males.isEmpty()){
            text.append("none");
        } else {
            for (int i = 0; i < males.size(); i++) {
                if (i < males.size() - 1){
                    text.append(String.format("%d, ", males.get(i)));
                } else {
                    text.append(males.get(i));
                }
            }
        }
        //On the third line - print all females left:
        //If there are no females: "Females left: none"
        //If there are females: "Females left: {female1}, {female2}, {female3}, (…)"
        text.append(System.lineSeparator());
        text.append("Females left: ");
        if(females.isEmpty()){
            text.append("none");
        } else {
            for (int i = 0; i < females.size(); i++) {
                if (i < females.size() - 1){
                    text.append(String.format("%d, ", females.get(i)));
                } else {
                    text.append(females.get(i));
                }
            }
        }
        System.out.println(text);

    }

    public static void remove25(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 25 == 0) {
                if (i < list.size() - 1) {
                    list.remove(i);
                    list.remove(i);
                    i--;
                } else {
                    list.remove(i);
                    break;
                }
            }
        }
    }

    public static void removeZeroAndBelow(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= 0) {
                list.remove(i);
                i--;
            }
        }
    }
}
