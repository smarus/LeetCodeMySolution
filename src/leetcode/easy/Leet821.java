package leetcode.easy;

import java.util.Arrays;

public class Leet821 {

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        System.out.println(Arrays.toString(shortestToChar(S, C)));
    }

    public static int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            System.out.println("--Ascending after" + ans[i]);
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
            System.out.println("--Ascending after" + ans[i]);

        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            System.out.println("--Descending befor" + ans[i]);
            ans[i] = Math.min(ans[i], prev - i);
            System.out.println("--Descending after" + ans[i]);

        }

        return ans;
    }
}
