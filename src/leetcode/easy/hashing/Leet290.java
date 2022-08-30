package leetcode.easy.hashing;

import java.util.HashMap;
import java.util.Map;

public class Leet290 {
    public static void main(String[] args) {
        String patter = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(patter, str));

        patter = "abba";
        str = "dog cat cat fish";
        System.out.println(wordPattern(patter, str));
        patter = "aaaa";
        str = "dog cat cat dog";
        System.out.println(wordPattern(patter, str));
        patter = "abba";
        str = "dog dog dog dog";
        System.out.println(wordPattern(patter, str));


    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (str.length() != pattern.length()) return false;

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String mapValue = map.get(pattern.charAt(i));
                if (!mapValue.equals(strs[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), strs[i]);
            }
        }

        String previous = "";
        for (Map.Entry<Character, String> pair : map.entrySet()) {
            if (previous.equals(pair.getValue()))
                return false;
            previous = pair.getValue();
        }

        return true;
    }
}
