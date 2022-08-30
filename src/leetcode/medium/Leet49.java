package leetcode.medium;

import java.util.*;

public class Leet49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> group = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            groupOfStrings(group, strs[i]);
        }

        List<List<String>> groupOfAnagram = new ArrayList<>();
        for (Map.Entry<String, List<String>> pair : group.entrySet()) {
            groupOfAnagram.add(pair.getValue());
        }

        return groupOfAnagram;

    }

    public static void groupOfStrings(Map<String, List<String>> group, String str) {
        int[] alfabet = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            alfabet[currentChar - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alfabet.length; i++) {

            while (alfabet[i] > 0) {
                char currentChar = (char) (i + 'a');
                sb.append(currentChar);
                alfabet[i]--;
            }
        }
        String alfabetChar = sb.toString();
        if (!group.containsKey(alfabetChar)) {
            group.put(alfabetChar, new ArrayList<>());
        }
        group.get(alfabetChar).add(str);

    }

}
