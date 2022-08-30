package leetcode.medium.string;

public class Leet5 {
    //    Input: s = "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
    public String longestPalindrome(String s) {
        if (s == null)
            return null;

        if (s.length() == 0)
            return s;


        int maxLength = 0;
        StringBuilder sb = new StringBuilder(s.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                if (sb.length() > maxLength) {
                    result = sb;
                }
            }
        }

        return result.toString();
    }

    public boolean isPalindrome(StringBuilder sb) {
        int lo = 0;
        int hi = sb.length() - 1;

        while (lo <= hi) {
            if (sb.charAt(lo) != sb.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
