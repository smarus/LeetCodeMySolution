package repeat.contest.route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SumPay {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        while (TC-- > 0) {
            int productBought = Integer.parseInt(reader.readLine());
            String[] products = reader.readLine().split(" ");
            Map<String, Integer> counts = new HashMap<>();
            for (int i = 0; i < products.length; i++) {
                counts.put(products[i], counts.getOrDefault(products[i], 0) + 1);
            }
            int sum = 0;
            for (Map.Entry<String, Integer> pair : counts.entrySet()) {
                int quantity = pair.getValue() - (pair.getValue() / 3);
                int product = Integer.parseInt(pair.getKey());
                sum += product * quantity;

            }
            System.out.println(sum);
        }
    }
}
