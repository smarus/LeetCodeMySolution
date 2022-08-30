package leetcode.easy.dp;

public class Leet198 {

    int[] dp;

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{2, 7, 9, 3, 1};
        int max = rob(nums);
        int max2 = rob(nums2);
        System.out.println(max);
        System.out.println(max2);

    }
//    public static int rob(int[] nums) {
//        int n = nums.length - 1;
//        dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        if(n == 1){
//            return Math.max(nums[0],nums[1]);
//        }
//        return maxRob(nums, n);
//    }
//
//    public static int rob(int[] nums) {
//         int n = nums.length;
//         int [] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = nums[1];
//         dp[2] = Math.max(dp[1], dp[0]+nums[2]);
//         for(int i = 3; i<nums.length;i++){
//             dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2]+ nums[i],dp[i -3] + nums[i]));
//         }
//        System.out.println(Arrays.toString(dp));
//         return dp[n -1];
//        }

    public static int rob(int[] nums) {
        int first = nums[0];
        int second = nums[1];
        int third = Math.max(second, first + nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int current = Math.max(third, Math.max((second + nums[i]), (first + nums[i])));
            first = second;
            second = third;
            third = current;
        }
        return Math.max(Math.max(first, second), third);
    }


    public int maxRob(int[] nums, int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return nums[n];
        if (dp[n] != -1)
            return dp[n];

        dp[n] = Math.max(maxRob(nums, n - 1), Math.max((maxRob(nums, n - 2) + nums[n]), (maxRob(nums, n - 3) + nums[n])));
        return dp[n];
    }
}
