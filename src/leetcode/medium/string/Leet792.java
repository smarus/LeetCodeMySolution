package leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

public class Leet792 {

//    Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
//    A subsequence of a string is a new string
//    generated from the original string with some characters (can be none)
//    deleted without changing the relative order of the remaining characters.
//    For example, "ace" is a subsequence of "abcde".

//    Input: s = "abcde", words = ["a","bb","acd","ace"]
//    Output: 3
//    Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

    //    Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//    Output: 2
    public static void main(String[] args) {
        String[] str = new String[]{"a", "bb", "acd", "ace"};
        String[] str2 = new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        numMatchingSubseq("dsahjpjauf", str2);
    }

    public static int numMatchingSubseq(String s, String[] words) {

        Map<String, Boolean> booleanMap = new HashMap<>();
        int count = 0;
        for (String str : words) {
            if (booleanMap.containsKey(str)) {
                if (booleanMap.get(str))
                    count++;

            } else if (isSubSequq(s, str)) {
                count++;
                booleanMap.put(str, true);
            } else {
                booleanMap.put(str, false);
            }
        }
        return count;
    }

    public static boolean isSubSequq(String s, String subseq) {
        int l = 0, r = 0;
        if (s.length() == 0)
            return false;
        if (subseq.length() == 0)
            return true;

        while (l < s.length()) {
            if (l < s.length() && r < subseq.length() && s.charAt(l) == subseq.charAt(r)) {
                l++;
                r++;
            } else {
                l++;
            }
        }
        return r == subseq.length();

    }
}
