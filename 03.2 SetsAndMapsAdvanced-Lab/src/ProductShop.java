import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String line = input.nextLine();
        while(!line.equals("Revision")){
            String shopName = line.split(",\\s+")[0];
            String product = line.split(",\\s+")[1];
            Double price = Double.parseDouble(line.split(",\\s+")[2]);
            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(product, price);
            line = input.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> shop : shops.entrySet()) {
            //fantastico->
            System.out.printf("%s->%n",shop.getKey());
            for (Map.Entry<String, Double> entry : shop.getValue().entrySet()) {
                //Product: apple, Price: 1.2
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(),entry.getValue());
            }

        }

    }
}
