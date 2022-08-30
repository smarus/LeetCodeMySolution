package leetcode.easy.two_pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet1481 {

    public static void main(String[] args) {
        int[] array = new int[]{5, 5, 4};
        int[] array2 = new int[]{4, 3, 1, 1, 3, 3, 2};
        System.out.println(findLeastNumOfUniqueInts(array, 1));
        System.out.println(findLeastNumOfUniqueInts(array2, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new
                PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> pair : freqMap.entrySet()) {
            minHeap.offer(pair);
        }

        int i = 0;
        while (i < k) {
            Map.Entry<Integer, Integer> pair = minHeap.peek();
            if (pair.getValue() > 0) {
                System.out.println(pair.getKey() + " " + pair.getValue());
                pair.setValue(pair.getValue() - 1);
                if (pair.getValue() == 0)
                    minHeap.poll();
            } else {
                System.out.println(pair.getKey() + " " + pair.getValue());
                minHeap.poll();
            }

            i++;
        }

        return minHeap.size();
    }
}
