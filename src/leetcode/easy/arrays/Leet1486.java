package leetcode.easy.arrays;

public class Leet1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2 * i;
        }
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
