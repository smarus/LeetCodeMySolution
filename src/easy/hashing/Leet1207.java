package easy.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leet1207 {
    public static void main(String[] args) {

    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : arr) {
            map.putIfAbsent(integer, 1);
            map.put(integer, map.get(integer) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (set.contains(pair.getValue())) {
                return false;
            }
            set.add(pair.getValue());
        }

        return true;
    }
}
