package leetcode.easy.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    //Recursive approuch
    static int[] memo;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1}; //4
        int[] nums2 = new int[]{2, 7, 9, 3, 1}; // 12

        System.out.println(robBottomUp(nums));
        System.out.println(robBottomUp(nums2));
    }

    public static int rob(int[] nums) {
        int n = nums.length - 1;
        memo = new int[n + 1];
        return robRecursiveMemo(nums, n);
    }

    public static int robRecursiveMemo(int[] nums, int n) {
        if (n == 0 || n == 1) {
            return nums[n];
        }
        if (memo[n] != 0)
            return memo[n];
        memo[n] = Math.max(robRecursive(nums, n - 1), (robRecursive(nums, n - 2) + nums[n]));
        return memo[n];
    }

    public static int robRecursive(int[] nums, int n) {
        if (n == 0 || n == 1) {
            return nums[n];
        }

        return Math.max(robRecursive(nums, n - 1), (robRecursive(nums, n - 2) + nums[n]));
    }

    public static int robBottomUp(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], (dp[i - 2] + nums[i]));
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

        }
        return dp[nums.length - 1];
    }

//    public static int robBottomUpWithoutExtraMemory(int [] nums){
//        if (nums.length == 0)
//            return 0;
//
//        int first = nums[0];
//        int second = nums[1];
//
//        for (int i = 2; i < nums.length;i++){
//            second = Math.max(second, first + nums[i]);
//            first =
//            dp[i] = Math.max(dp[i - 1], (dp[i - 2] + nums[i]));
//        }
//
//        return dp[nums.length - 1];
//    }


}
