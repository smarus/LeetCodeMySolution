package leetcode.easy.binara_search;

public class Leet486 {
    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
            } else {
                ones = 0;
            }

            if (ones > max) {
                max = ones;
            }
        }
        return max;
    }
}
