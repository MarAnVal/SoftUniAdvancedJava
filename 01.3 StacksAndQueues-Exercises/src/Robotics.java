import java.util.*;

public class Robotics {
    public static String timer(String clock, int current) {
        int hours = Integer.parseInt(clock.split(":")[0]);
        int minutes = Integer.parseInt(clock.split(":")[1]);
        int seconds = Integer.parseInt(clock.split(":")[2]);
        seconds += current;
        if (seconds / 60 >= 0) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        if (minutes / 60 >= 0) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
        if (hours / 24 >= 0) {
            hours = hours % 24;
        }
        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, Integer> robotsTime = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> robotsEnd = new LinkedHashMap<>();
        String[] line = input.nextLine().split(";");
        for (String element : line) {
            robotsTime.put(element.split("-")[0], Integer.parseInt(element.split("-")[1]));
            robotsEnd.put((element.split("-")[0]), 0);
        }

        String clock = input.nextLine();

        ArrayDeque<String> tasksQueue = new ArrayDeque<>();
        String task = input.nextLine();
        while (!task.equals("End")) {
            tasksQueue.offer(task);
            task = input.nextLine();
        }
        int secCount = 1;

        while (!tasksQueue.isEmpty()) {
            boolean busy = true;
            for (Map.Entry<String, Integer> entry : robotsEnd.entrySet()) {
                if (entry.getValue() <= secCount) {
                    System.out.printf("%s - %s %s%n", entry.getKey(), tasksQueue.poll(),
                            timer(clock, secCount));
                    robotsEnd.put(entry.getKey(), robotsTime.get(entry.getKey()) + secCount);
                    secCount++;
                    busy = false;
                    break;
                }
            }
            if (busy) {
                tasksQueue.offer(tasksQueue.poll());
                secCount++;
            }
        }

    }
}
