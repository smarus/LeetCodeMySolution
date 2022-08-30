package educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

//Given a string with lowercase letters only,
// if you are allowed to replace no more than
// ‘k’ letters with any letter, find the length
// of the longest substring having
// the same letters after replacement.
public class CharacterReplacement {
    public static void main(String[] args) {
        String s1 = "aabccbb";
        int k = 2;
        String s2 = "aa";
        int k1 = 1;
        String s3 = "aabccbb";
        int k2 = 1;
        System.out.println(findLength(s1, k));
        System.out.println(findLength(s2, k1));
        System.out.println(findLength(s3, k2));
    }

    public static int findLength(String str, int k) {
        if (str.length() == 0)
            return 0;

        int start = 0;
        int maxRepeatingCharacter = 0;
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatingCharacter = Math.max(maxRepeatingCharacter, freqMap.get(rightChar));

            if (end - start + 1 - maxRepeatingCharacter > k) {
                char leftChar = str.charAt(start);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                start++;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;
    }
}
