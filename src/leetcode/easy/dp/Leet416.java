package leetcode.easy.dp;

import java.util.Arrays;

public class Leet416 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        int[] num2 = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition(num2));
    }

    public static boolean canPartition(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        Arrays.sort(nums);
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        int difference = 0;
        for (int i = 0; i < prefixSum.length; i++) {

        }

        return prefixSum[prefixSum.length - 1] - prefixSum[prefixSum.length - 2] == prefixSum[prefixSum.length - 2];
    }
}
