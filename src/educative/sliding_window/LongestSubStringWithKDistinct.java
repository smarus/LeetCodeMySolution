package educative.sliding_window;


//Given a string, find the length of the
// longest substring in it with no
// more than K distinct characters.


import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinct {
    public static void main(String[] args) {
        String s = "arraci", s1 = "arraci", s2 = "cbbebi";
        int k = 2, k1 = 1, k2 = 3;
        System.out.println(findLength(s, k));
        System.out.println(findLength(s1, k1));
        System.out.println(findLength(s2, k2));
    }

    public static int findLength(String str, int k) {
        int ws = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap();
        for (int wd = 0; wd < str.length(); wd++) {
            char rightChar = str.charAt(wd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while (map.size() > k) {
                char leftChar = str.charAt(ws);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);
                ws++;
            }
            max = Math.max(max, wd - ws + 1);
        }
        return max;
    }
}
