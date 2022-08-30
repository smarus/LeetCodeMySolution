package leetcode.medium.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leet451 {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(null == null);
    }


    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k1).compareTo(map.get(k2));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }


    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sortedMap = sortByValues(map);

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> pair : sortedMap.entrySet()) {
            for (int i = 0; i < pair.getValue(); i++) {
                stringBuilder.append(pair.getKey());
            }
        }

        return stringBuilder.reverse().toString();

    }
}
