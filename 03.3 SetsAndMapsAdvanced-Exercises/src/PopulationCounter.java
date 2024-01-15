import java.util.*;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Map<String, Map<String, Integer>> countryCityMap = new LinkedHashMap<>();
        Map<String, Long> countryPopulationMap = new LinkedHashMap<>();
        while (!line.equals("report")) {
            //"city|country|population"
            String city = line.split("\\|")[0];
            String country = line.split("\\|")[1];
            int population = Integer.parseInt(line.split("\\|")[2]);
            countryCityMap.putIfAbsent(country, new LinkedHashMap<>());
            countryCityMap.get(country).put(city, population);
            countryPopulationMap.putIfAbsent(country, 0L);
            countryPopulationMap.put(country, countryPopulationMap.get(country) + population);
            line = input.nextLine();
        }
        countryPopulationMap = countryPopulationMap.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue , (e1, e2) -> e2, LinkedHashMap::new));


        for (Map.Entry<String, Long> entry : countryPopulationMap.entrySet()) {
            String country = entry.getKey();
            Long populationAll = entry.getValue();
            //Bulgaria (total population: 1000000)
            System.out.printf("%s (total population: %d)%n", country, populationAll);
            Map<String, Integer> cityPopulation = countryCityMap.get(entry.getKey());
            cityPopulation = cityPopulation.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue()))
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue , (e1, e2) -> e2, LinkedHashMap::new));
            for (Map.Entry<String, Integer> city : cityPopulation.entrySet()) {
                //=>Sofia: 1000000
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            }

        }
    }
}
