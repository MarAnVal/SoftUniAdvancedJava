package Exam_22_October_2022;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String carNumber = input.nextLine();
        int tunel1I = -1;
        int tunel1J = -1;
        int tunel2I = -1;
        int tunel2J = -1;
        int endI = -1;
        int endJ = -1;
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("T")) {
                    if (tunel1I > -1 && tunel1J > -1) {
                        tunel2I = i;
                        tunel2J = j;
                    } else {
                        tunel1I = i;
                        tunel1J = j;
                    }
                }
                if (line[j].equals("F")) {
                    endI = i;
                    endJ = j;
                }
            }
        }
        String command = input.nextLine();
        int km = 0;
        boolean finish = false;
        boolean tunel = false;
        while (!command.equals("End")) {
            switch (command) {
                case "left":
                    startJ -= 1;
                    km += 10;
                    if (startI == tunel1I && startJ == tunel1J && !tunel) {
                        startI = tunel2I;
                        startJ = tunel2J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == tunel2I && startJ == tunel2J && !tunel) {
                        startI = tunel1I;
                        startJ = tunel1J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == endI && startJ == endJ) {
                        finish = true;
                    }
                    break;
                case "right":
                    startJ += 1;
                    km += 10;
                    if (startI == tunel1I && startJ == tunel1J && !tunel) {
                        startI = tunel2I;
                        startJ = tunel2J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == tunel2I && startJ == tunel2J && !tunel) {
                        startI = tunel1I;
                        startJ = tunel1J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == endI && startJ == endJ) {
                        finish = true;
                    }
                    break;
                case "up":
                    startI -= 1;
                    km += 10;
                    if (startI == tunel1I && startJ == tunel1J && !tunel) {
                        startI = tunel2I;
                        startJ = tunel2J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == tunel2I && startJ == tunel2J && !tunel) {
                        startI = tunel1I;
                        startJ = tunel1J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == endI && startJ == endJ) {
                        finish = true;
                    }
                    break;
                case "down":
                    startI += 1;
                    km += 10;
                    if (startI == tunel1I && startJ == tunel1J && !tunel) {
                        startI = tunel2I;
                        startJ = tunel2J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == tunel2I && startJ == tunel2J && !tunel) {
                        startI = tunel1I;
                        startJ = tunel1J;
                        km += 20;
                        tunel = true;
                    }
                    if (startI == endI && startJ == endJ) {
                        finish = true;
                    }
                    break;
            }
            if (finish) {
                break;
            } else {
                command = input.nextLine();
            }
        }
        if(finish){
            //"Racing car {racing number} finished the stage!"
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        }else {
            //"Racing car {racing number} DNF."
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        //"Distance covered {kilometers passed} km."
        System.out.printf("Distance covered %d km.%n", km);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == startI && j == startJ){
                    System.out.print("C");
                } else if(!finish && i == endI && j == endJ){
                    System.out.print("F");
                } else if (!tunel && i == tunel1I && j == tunel1J){
                    System.out.print("T");
                }else if (!tunel && i == tunel2I && j == tunel2J){
                    System.out.print("T");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        //.....
        //.....
        //.....
        //.....
        //..C..
    }
}
