import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String, Map<String, List<String>>> notes = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String continent = line.split("\\s+")[0];
            String country = line.split("\\s+")[1];
            String city = line.split("\\s+")[2];
            notes.putIfAbsent(continent, new LinkedHashMap<>());
            notes.get(continent).putIfAbsent(country, new ArrayList<>());
            notes.get(continent).get(country).add(city);
        }
        for (Map.Entry<String, Map<String, List<String>>> continents : notes.entrySet()) {
            //Europe:
            System.out.printf("%s:%n", continents.getKey());
            for (Map.Entry<String, List<String>> countries : continents.getValue().entrySet()) {
                System.out.printf("  %s -> ", countries.getKey());
                //Bulgaria -> Sofia, Plovdiv
                System.out.println(String.join(", ", countries.getValue()));
            }
        }
    }
}
