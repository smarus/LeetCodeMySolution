package leetcode.easy.arrays;


import java.util.ArrayList;
import java.util.List;
//Given an array A of strings made only from lowercase letters, return
// a list of all characters that show up in all strings within the
// list (including duplicates).  For example,
// if a character occurs 3 times in all strings but not 4 times,
// you need to include that character three times in the final answer.
//
//You may return the answer in any order.

public class Leet1002 {
    public static void main(String[] args) {
        String[] input = new String[]{"bella", "label", "roller"};

        List<String> string = commonChars(input);

        for (String s : string)
            System.out.println(s);
    }

    public static List<String> commonChars(String[] A) {
        // use two frequency arrays
        // 'freqs' holds our answer as we build it
        // 'compare' holds each String as we iterate
        // as we inspect it
        int[] freqs = new int[26];
        int[] compare = new int[26];

        // initialize the 'freqs' array with the frequencies
        // found in the first String
        String first = A[0];
        for (char c : first.toCharArray()) {
            freqs[c - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            // build the 'compare' array with frequency of
            // each character occurring in the current String
            for (char c : A[i].toCharArray()) {
                compare[c - 'a']++;
            }
            // whittle the 'freqs' values down by using Math.min()
            // with the frequencies found in the current String
            // also reset the 'compare' array for next iteration
            for (int j = 0; j < 26; j++) {
                System.out.println("Freqs[j] = " + freqs[j] +
                        " compare[j]=" + compare[j]);
                freqs[j] = Math.min(freqs[j], compare[j]);
                compare[j] = 0;
            }
        }

        // at this point, 'freqs' contains the minimum occurrence
        // frequency for each character a-z across all the Strings

        // construct the required List<String> answer
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            while (freqs[i]-- > 0) {
                result.add(Character.toString((char) ('a' + i)));
            }
        }
        return result;
    }
}
