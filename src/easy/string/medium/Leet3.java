package easy.string.medium;

import java.util.HashSet;

public class Leet3 {

//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.

//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.


    //    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("dvdf"));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        HashSet<Character> characters = new HashSet<>();
        int counter = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i));
                counter++;
            } else {
                if (counter > maxLen)
                    maxLen = counter;
                characters.clear();
                characters.add(s.charAt(i));
                counter = 1;

            }
        }

        if (counter > maxLen) {
            maxLen = counter;
        }

        counter = 0;
        characters.clear();
        int reversedMaxLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i));
                counter++;
            } else {
                if (counter > reversedMaxLen)
                    reversedMaxLen = counter;
                characters.clear();
                characters.add(s.charAt(i));
                counter = 1;
            }

        }


        return Math.max(maxLen, reversedMaxLen);

    }
}
