package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Leet560 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1};
        int[] array2 = new int[]{1, 2, 3};


        System.out.println(subArraySum(array, 2));
        System.out.println(subArraySum(array2, 3));
    }


    public static int subArraySum(int[] array, int k) {

        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j];


                if (sum == k)
                    count++;
            }
        }

        return count;
    }

    public static int subArrayOptimized(int[] array, int k) {
        Map<Integer, Integer> mapOfOccurrences = new HashMap<>();
        int sum = 0;
        int count = 0;
        mapOfOccurrences.put(0, 1);
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (mapOfOccurrences.containsKey(sum - k)) {
                count += mapOfOccurrences.getOrDefault(sum - k, 0);
            }
            mapOfOccurrences.put(sum, mapOfOccurrences.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


}
