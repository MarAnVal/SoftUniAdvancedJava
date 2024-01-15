package Exam_19_February_2022;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        LinkedHashMap<String, List<String>> words = new LinkedHashMap<>();
        //"pear"
        words.put("pear", new ArrayList<>(Arrays.asList("pear".split(""))));
        //"flour"
        words.put("flour", new ArrayList<>(Arrays.asList("flour".split(""))));
        //"pork"
        words.put("pork", new ArrayList<>(Arrays.asList("pork".split(""))));
        //"olive"
        words.put("olive", new ArrayList<>(Arrays.asList("olive".split(""))));

        Scanner input = new Scanner(System.in);
        // two sequences of characters, representing vowels and consonants.
        String[] vowels = input.nextLine().split("\\s+");
        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        for (int i = 0; i < vowels.length; i++) {
            vowelsQueue.offer(vowels[i]);
        }
        String[] consonants = input.nextLine().split("\\s+");
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        for (int i = 0; i < consonants.length; i++) {
            consonantsStack.push(consonants[i]);
        }
        //first character of the vowels collection and the last character from the consonants
        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();
            for (Map.Entry<String, List<String>> entry : words.entrySet()) {
                entry.getValue().remove(vowel);
                entry.getValue().remove(consonant);
            }
            vowelsQueue.offer(vowel);
        }
        StringBuilder wordsFound = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            if (entry.getValue().isEmpty()) {
                count++;
                wordsFound.append(System.lineSeparator());
                wordsFound.append(entry.getKey());
            }
        }
        System.out.printf("Words found: %d %s%n", count, wordsFound);
    }
}
