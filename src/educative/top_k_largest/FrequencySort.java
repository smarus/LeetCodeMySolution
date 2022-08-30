package educative.top_k_largest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        String s = "Programming";
        System.out.println(sortCharacterByFrequency(s));
    }

    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        minHeap.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!minHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = minHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
