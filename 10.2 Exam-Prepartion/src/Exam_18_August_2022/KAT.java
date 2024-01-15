package Exam_18_August_2022;

import java.util.*;

public class KAT {
    public static void main(String[] args) {
        //two sequences of integers – one with license plates and one with cars
        Scanner input = new Scanner(System.in);
        ArrayDeque<Integer> licensesList = new ArrayDeque<>();
        String[] firstLine = input.nextLine().split(",\\s*");
        for (int i = 0; i < firstLine.length; i++) {
            int element = Integer.parseInt(firstLine[i]);
            licensesList.offer(element);
        }
        ArrayDeque<Integer> carsList = new ArrayDeque<>();
        String[] secondLine = input.nextLine().split(",\\s*");
        for (int i = secondLine.length - 1; i >= 0; i--) {
            int element = Integer.parseInt(secondLine[i]);
            carsList.offer(element);
        }
        List<Integer> doneCars = new ArrayList<>();
        while (!(carsList.isEmpty() || licensesList.isEmpty())) {
            int cars = carsList.poll();
            int licenses = licensesList.poll();
            if (licenses < cars * 2) {
                doneCars.add(licenses / 2);
                int leftCars = Math.abs(licenses / 2 - cars);
                carsList.offer(leftCars);
            } else {
                doneCars.add(cars);
                int leftLicenses = licenses - cars * 2;
                if (leftLicenses > 0) {
                    licensesList.offer(leftLicenses);
                }
            }
        }
        //Print count of registered cars and how many days were needed:
        //“{count of registered cars} cars were registered for {count of days} days!”
        long result = 0L;
        for (int i = 0; i < doneCars.size(); i++) {
            result += (long) doneCars.get(i);
        }
        StringBuilder text = new StringBuilder();
        text.append(String.format("%d cars were registered for %d days!", result, doneCars.size()));
        if (carsList.isEmpty() && licensesList.isEmpty()) {
            //If all cars and license plates were used:
            //"Good job! There is no queue in front of the KAT!"
            text.append(System.lineSeparator());
            text.append("Good job! There is no queue in front of the KAT!");
        } else {
            if (!licensesList.isEmpty()) {
                //If there are any remaining license plates:
                //“{count of plates} license plates remain!”
                long leftLicenses = 0L;
                while (!licensesList.isEmpty()) {
                    leftLicenses += (long) licensesList.poll();
                }
                text.append(System.lineSeparator());
                text.append(String.format("%d license plates remain!", leftLicenses));
            } else {
                //If any cars are remaining without license plates:
                //“{count of cars without license plates} cars remain without license plates!”
                long leftCars = 0L;
                while (!carsList.isEmpty()) {
                    leftCars += (long) carsList.poll();
                    carsList.remove(0);
                }
                text.append(System.lineSeparator());
                text.append(String.format("%d cars remain without license plates!", leftCars));
            }
        }
        System.out.println(text);
    }
}
