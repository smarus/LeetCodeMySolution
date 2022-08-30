package leetcode.easy.dp;

public class Leet152 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        return maxProduct(nums, nums.length - 1);

    }

    public static int maxProduct(int[] nums, int i) {
        if (i < 0)
            return 0;

        int product = Math.max(nums[i], maxProduct(nums, i - 1) * nums[i]);
        return product;
    }
}
