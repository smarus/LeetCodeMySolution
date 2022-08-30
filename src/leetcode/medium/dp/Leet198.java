package leetcode.medium.dp;

import java.util.Arrays;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount
//        of money stashed, the only constraint stopping you from robbing each of them is that
//        adjacent houses have security systems connected and it will automatically contact
//        the police if two adjacent houses were broken into on the same night.
//
//        Given an integer array nums representing the amount of money of each house,
//        return the maximum amount of money you can rob tonight without alerting the police.
public class Leet198 {


    public static void main(String[] args) {
        //        Rob house 1 (money = 1) and then rob house 3 (money = 3).
//                Total amount you can rob = 1 + 3 = 4.
        int[] array = new int[]{1, 2, 3, 1};
        int[] array2 = new int[]{2, 7, 9, 3, 1};
//        Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//                Total amount you can rob = 2 + 9 + 1 = 12.

        System.out.println(rob(array));
        System.out.println(rob(array2));
    }

    //TOP Down Approuch
//    public static int rob(int[] nums) {
//        int [] memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//        return helper(nums, nums.length - 1, memo);
//
//    }
//
//    public static int helper(int [] nums , int index, int[] memo){
//        if(index < 0)
//            return 0;
//        if (memo[index] != -1)
//            return memo[index];
//        int currentNumber = nums[index] + helper(nums , index - 2, memo);
//        int prevNumber = helper(nums, index - 1, memo);
//         memo[index] =  Math.max(currentNumber, prevNumber);
//         return memo[index];
//    }
//}  // Bottom UP with array
//    public static int rob(int[] nums) {
//        int [] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = nums[1];
//        for(int i = 2;i<nums.length;i++){
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]);
//        }
//        System.out.println(Arrays.toString(dp));
//        return dp[nums.length - 1];
//    }
//
//    }
    //Bottom up without array
    public static int rob(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int prev = nums[0];
        int current = nums[1];
        for (int i = 2; i < nums.length; i++) {
            current = Math.max(prev + nums[i], current);
            prev = current - prev;
        }
        return current;
    }

}


