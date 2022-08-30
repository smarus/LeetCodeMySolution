package leetcode.easy.hashing;

import java.util.*;

public class Leet49 {
    public static void main(String[] args) {
        String[] array = new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        List<List<String>> lists = groupAnagrams(array);
        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            list.forEach(System.out::println);
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strings = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String key = getKey(s);
            if (strings.containsKey(key)) {
                List<String> list = strings.get(key);
                list.add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                strings.put(key, list);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> pair : strings.entrySet()) {
            list.add(pair.getValue());
        }
        return list;
    }

    public static String getKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars);
    }
}
