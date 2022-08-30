package educative.sliding_window;

//Given an array of characters where each character
//        represents a fruit tree, you are given two baskets and
//        your goal is to put maximum number of fruits in each basket.
//        The only restriction is that each basket can have only one type of fruit.
//        You can start with any tree, but once you have started you can’t skip a tree.
//        You will pick one fruit from each tree until you cannot, i.e.,
//        you will stop when you have to pick from a third fruit type.
//        Write a function to return the maximum number of fruits in both the baskets.

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'B', 'C', 'A', 'C'};
        char[] chars2 = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLength(chars));
        System.out.println(findLength(chars2));
    }

    public static int findLength(char[] arr) {
        int ws = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int wd = 0; wd < arr.length; wd++) {
            char leftChar = arr[wd];
            map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
            while (map.size() > 2) {
                char rightChar = arr[ws];
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    map.remove(rightChar);
                }
                ws++;
            }
            max = Math.max(max, wd - ws + 1);
        }
        return max;
    }

    // O(n)time O(1)Space
    public int totalFruit(int[] tree) {
        // track last two fruits seen
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;

        for (int fruit : tree) {
            if (fruit == lastFruit || fruit == secondLastFruit)
                currMax++;
            else
                currMax = lastFruitCount + 1; // last fruit + new fruit

            if (fruit == lastFruit)
                lastFruitCount++;
            else
                lastFruitCount = 1;

            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }
}
