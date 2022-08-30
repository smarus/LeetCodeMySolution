package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet249 {

    public static void main(String[] args) {
        String[] strings = new String[]{"a", "z", "abc", "bcd", "xyz, acef"};
        System.out.println(groupShift(strings));
    }


    static List<List<String>> groupShift(String[] strings) {

        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                int relativeOrder = (str.charAt(i) - str.charAt(0) + 26) % 26;
                sb.append("#");
                sb.append(relativeOrder);
            }
            String key = sb.toString();
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }

            groupMap.get(key).add(str);
        }

        return new ArrayList<>(groupMap.values());
    }
}
