package leetcode.medium.string;

import java.util.*;

public class Leet567 {
    public static void main(String[] args) {
        // System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;

        if (s1.length() > s2.length()) {
            return false;
        }

        int start = 0;
        int window = s1.length() - 1;
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        s1 = new String(chars1);
        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 1);
        StringBuilder sb = new StringBuilder();
        for (int end = 0; end < s2.length(); end++) {
            char leftChar = s2.charAt(end);
            if (end > window) {
                char[] chars2 = sb.toString().toCharArray();
                Arrays.sort(chars2);
                String db = new String(chars2);
                System.out.println(db);
                if (map.containsKey(db)) {
                    return true;
                }
                sb.deleteCharAt(0);
            }
            sb.append(leftChar);

        }

        return false;
    }
}
