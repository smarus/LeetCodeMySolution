package leetcode.easy.bit_operation;

public class Leet136 {
    public static void main(String[] args) {

    }


    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];

    }
}
