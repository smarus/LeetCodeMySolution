package easy.arrays;

import java.util.Arrays;

public class Leet122 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        boolean isAscend = true;
        boolean isDescend = true;
        for (int i = 0; i < prices.length - 1; i++) {
            if (!(prices[i] >= prices[i + 1])) {
                isAscend = false;
            } else if (!(prices[i] <= prices[i + 1])) {
                isDescend = false;
            }
        }

        if (!isAscend) {
            return 0;
        }
        if (!isDescend) {
            return prices[prices.length - 1] - prices[0];
        }


        return 3;
    }
}
