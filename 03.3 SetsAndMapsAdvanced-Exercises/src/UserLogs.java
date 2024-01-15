import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Map<String, Map<String, Integer>> usersIPCount = new TreeMap<>();
        while (!line.equals("end")) {
            String ipAll = line.split("\\s+")[0];
            String ip = ipAll.split("=")[1];
            String userAll = line.split("\\s+")[2];
            String user = userAll.split("=")[1];
            usersIPCount.putIfAbsent(user, new LinkedHashMap<>());
            usersIPCount.get(user).putIfAbsent(ip, 0);
            usersIPCount.get(user).put(ip, usersIPCount.get(user).get(ip) + 1);

            line = input.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : usersIPCount.entrySet()) {
            System.out.println(entry.getKey() + ":");
            List<String> buffer = new ArrayList<>();
            for (Map.Entry<String, Integer> element : entry.getValue().entrySet()) {
                String tab = element.getKey() + " => " + element.getValue();
                buffer.add(tab);
            }
            System.out.print(String.join(", ", buffer));
            System.out.println(".");

        }

    }
}
