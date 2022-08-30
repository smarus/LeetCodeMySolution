import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArray {

    public static void main(String[] args) {

        int[] array = new int[]{2, 1, 5, 2, 3, 2};
        int s = 7;

        int sum = 0;
        int start = 0;

//        System.out.println(longestSubstringWithK("arraci", 2));
//        System.out.println(longestSubstringWithK("arraci", 1));
//        System.out.println(longestSubstringWithK("cbbebi", 3));


//        System.out.println(longestSubstringWithNoRepeat("aabccbb"));
//        System.out.println(longestSubstringWithNoRepeat("abbbb"));
//        System.out.println(longestSubstringWithNoRepeat("abccde"));


        System.out.println(longestAfterReplacement("aabccbb", 2));
        System.out.println(longestAfterReplacement("abbcb", 1));

    }

    // arraci k = 2  == 4 == arra
    public static int longestSubstringWithK(String string, int k) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int right = 0; right < string.length(); right++) {
            char rightChar = string.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while (map.size() > k) {
                char leftChar = string.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);

                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int longestSubstringWithNoRepeat(String string) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int right = 0; right < string.length(); right++) {
            char rightChar = string.charAt(right);
            if (map.containsKey(rightChar)) {
                left = Math.max(left, map.get(rightChar) + 1);
            }
            map.put(rightChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int longestAfterReplacement(String str, int k) {
        int maxRepeatedCharacter = 0;
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            maxRepeatedCharacter = Math.max(maxRepeatedCharacter, map.get(endChar));

            if (end - start + 1 - maxRepeatedCharacter > k) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


}
