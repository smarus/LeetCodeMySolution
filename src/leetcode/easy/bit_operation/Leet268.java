package leetcode.easy.bit_operation;

public class Leet268 {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums2 = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber(nums2));
    }

    public static int missingNumber(int[] nums) {
        int c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            c = c ^ nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            c = c ^ i;
        }


        System.out.println(c);
        return c;

    }
}
