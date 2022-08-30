package leetcode.easy;

import java.util.Arrays;

public class SumClosest {


    public static void main(String[] args) {

        int[] array = new int[]{-4, 1, -1, 2};
        int[] arra2 = new int[]{0, 0, 0};
        System.out.println(threeSumClosest(array, 1));
        System.out.println(threeSumClosest(arra2, 1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);
        int minimumDiff = Integer.MAX_VALUE;
        int minimumTarget = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];

                int diff = Math.abs(currentSum - target);

                if (diff < minimumDiff) {
                    minimumDiff = diff;
                    minimumTarget = currentSum;
                }

                if (currentSum < target)
                    start++;
                else
                    end--;
            }
        }

        return minimumTarget;
    }
}
