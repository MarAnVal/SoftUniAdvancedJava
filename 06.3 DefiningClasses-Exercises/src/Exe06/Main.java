package Exe06;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, List<String>> trainerElementsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Trainer> trainersMap = new LinkedHashMap<>();
        String line = input.nextLine();
        while (!line.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String[] parts = line.split("\\s+");
            String trainerName = parts[0];
            String pokemonName = parts[1];
            String pokemonElement = parts[2];
            int pokemonHealth = Integer.parseInt(parts[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainersMap.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName, new ArrayList<>());
                trainer.getCollection().add(pokemon);
                trainerElementsMap.put(trainerName, new ArrayList<>());
                trainerElementsMap.get(trainerName).add(pokemonElement);
                trainersMap.put(trainerName, trainer);
            } else {
                Trainer trainer = trainersMap.get(trainerName);
                trainer.getCollection().add(pokemon);
                trainerElementsMap.get(trainerName).add(pokemonElement);
            }
            line = input.nextLine();
        }

        String command = input.nextLine();
        while (!command.equals("End")) {
            for (Map.Entry<String, List<String>> entry : trainerElementsMap.entrySet()) {
                List<String> elementList = entry.getValue();
                if (elementList.contains(command)) {
                    int badges = trainersMap.get(entry.getKey()).getBadges();
                    trainersMap.get(entry.getKey()).setBadges(badges + 1);
                } else {
                    List<Pokemon> pokemonList = trainersMap.get(entry.getKey()).getCollection();
                    for (int i = 0; i < pokemonList.size(); i++) {
                        Pokemon pokemon = pokemonList.get(i);
                        int health = pokemon.getHealth();
                        if (health - 10 <= 0) {
                            trainerElementsMap.get(entry.getKey()).remove(pokemon.getElement());
                            pokemonList.remove(pokemon);
                            i--;
                        } else {
                            pokemon.setHealth(health - 10);
                        }
                    }
                    trainersMap.get(entry.getKey()).setCollection(pokemonList);
                }
            }
            command = input.nextLine();
        }
        Map<Trainer, Integer> printMap = new LinkedHashMap<>();
        for (Map.Entry<String, Trainer> entry : trainersMap.entrySet()) {
          printMap.put(entry.getValue(), entry.getValue().getBadges());
        }
        printMap = printMap.entrySet().stream().
                sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue , (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<Trainer, Integer> entry : printMap.entrySet()) {
            System.out.println(entry.getKey().toString());
        }


    }
}
