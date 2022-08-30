package leetcode.easy.dp;

import java.util.Arrays;

public class Leet746 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 20};
        int[] array2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(array));
        System.out.println(minCostClimbingStairs(array2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        System.out.println(Arrays.toString(dp));
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
