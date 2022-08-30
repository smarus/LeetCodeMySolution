package educative.sliding_window;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        String s = "aabccbb", pattern = "abc"; // 3
        String s2 = "abbbb", pattern2 = "dc"; // 2
        String s3 = "abccde", pattern3 = "abc"; //  3

        System.out.println(findLengthBrutForce(s));
        System.out.println(findLengthBrutForce(s2));
        System.out.println(findLengthBrutForce(s3));
    }

    public static int findLength(String str) {


        return -1;
    }

    public static int findLengthBrutForce(String str) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(str.charAt(i));
            for (int j = i + 1; j < str.length() - 1; j++) {
                char leftChar = str.charAt(j);
                if (!set.contains(leftChar)) {
                    set.add(leftChar);
                } else {
                    break;
                }
            }
            System.out.println(set);
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
