import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, TreeSet<String>> userIpMap = new TreeMap<>();
        Map<String, Integer> userDuration = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            //{IP} {user} {duration}
            String ip = line.split("\\s+")[0];
            String user = line.split("\\s+")[1];
            int duration = Integer.parseInt(line.split("\\s+")[2]);
            userIpMap.putIfAbsent(user, new TreeSet<>());
            userIpMap.get(user).add(ip);
            userDuration.putIfAbsent(user, 0);
            userDuration.put(user, userDuration.get(user) + duration);
        }
        for (Map.Entry<String, TreeSet<String>> entry : userIpMap.entrySet()) {
            //alex: 62 [10.10.17.33, 212.50.118.81]
            int time = userDuration.get(entry.getKey());
            System.out.printf("%s: %d %s%n", entry.getKey(), time, entry.getValue().toString());
        }
    }
}
