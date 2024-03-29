package leetcode.easy.arrays;

public class Leet1295 {
    public static void main(String[] args) {

        int[] nums = new int[]{12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) count++;
        }
        return count;
    }
}
