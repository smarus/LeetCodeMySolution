package leetcode.medium.string;

import java.util.*;

public class Leet438 {

    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));


    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<String, Integer> map = new HashMap();
        List<Integer> result = new ArrayList();

        char[] pChars = p.toCharArray();
        map.put(sort(pChars), 0);

        int start = 0;

        StringBuilder sb = new StringBuilder(p.length());
        for (int end = 0; end < s.length(); end++) {
            sb.append(s.charAt(end));
            if (sb.length() >= p.length()) {
                char[] chars = new char[sb.length()];
                sb.getChars(0, sb.length(), chars, 0);
                if (map.containsKey(sort(chars))) {
                    result.add(start);
                }
                start++;
                sb.deleteCharAt(0);
            }
        }
        return result;
    }


    public static String sort(char[] chars) {
        Arrays.sort(chars);
        return String.valueOf(chars);
    }


}
