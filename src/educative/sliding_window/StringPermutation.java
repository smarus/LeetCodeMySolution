package educative.sliding_window;

import java.util.HashMap;

//Given a string and a pattern,
// find out if the string contains any permutation of the pattern.
public class StringPermutation {
    public static void main(String[] args) {
        String s = "oidbcaf", pattern = "abc"; //bca
        String s2 = "odicf", pattern2 = "dc"; //false
        String s3 = "bcdxabcdy", pattern3 = "bcdyabcdx"; // true
        String s4 = "aaacb", pattern4 = "abc"; // acb

        System.out.println(findPermutation(s, pattern));
        System.out.println(findPermutation(s2, pattern2));
        System.out.println(findPermutation(s3, pattern3));
        System.out.println(findPermutation(s4, pattern4));
    }


    public static boolean findPermutation(String str, String pattern) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.equals(pattern))
            return true;

        int ws = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int wd = 0; wd < str.length(); wd++) {
            sb.append(str.charAt(wd));
            while (sb.length() >= pattern.length()) {
                int counter = 0;
                for (int i = 0; i < sb.length(); i++) {
                    if (!map.containsKey(sb.charAt(i))) {
                        counter--;
                    } else
                        counter++;
                }
                if (counter == pattern.length()) {
                    System.out.println(sb);
                    return true;
                }
                sb.deleteCharAt(0);
            }

        }

        return false;
    }
}
