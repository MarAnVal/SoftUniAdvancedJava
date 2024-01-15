import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split("\\s+");
            String name = line[0];
            double grade = Double.parseDouble(line[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            //Alex -> 2.00 3.00 (avg: 2.50)
            System.out.printf("%s -> ", entry.getKey());
            double average = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                average += entry.getValue().get(i);
                System.out.printf("%.2f ", entry.getValue().get(i));
            }
            average /= entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", average);
        }


    }
}
