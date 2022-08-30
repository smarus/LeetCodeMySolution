package leetcode.easy.string.easy;

import java.util.HashMap;
import java.util.Map;

public class Leet804 {
    static String[] alfabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
        String[] string = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(string));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String morse = getMorse(word);
            if (map.containsKey(morse)) {
                map.put(morse, map.get(morse) + 1);
            } else {
                map.put(morse, 1);
            }
        }
        return map.size();
    }

    public static String getMorse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(alfabet[s.charAt(i) - 'a']);
        }

        return sb.toString();
    }
}
