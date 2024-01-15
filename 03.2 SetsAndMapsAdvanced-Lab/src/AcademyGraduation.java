import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, Double> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = input.nextLine();
            String [] grades = input.nextLine().split("\\s+");
            double avarage = 0;
            for (int j = 0; j < grades.length; j++) {
                avarage += Double.parseDouble(grades[j]);
            }
            avarage /= grades.length;
            students.put(name, avarage);
        }
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            //George is graduated with 4.375
            DecimalFormat df = new DecimalFormat("0.##################");
            String lineString = "";
            lineString = df.format(entry.getValue());
            System.out.printf("%s is graduated with %s%n", entry.getKey(), lineString);
        }

    }
}
