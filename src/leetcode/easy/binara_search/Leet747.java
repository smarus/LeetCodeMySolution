package leetcode.easy.binara_search;

public class Leet747 {

    public static void main(String[] args) {

        int[] array = new int[]{3, 6, 1, 0};
        int[] array2 = new int[]{1, 2, 3, 4};
        int[] array3 = new int[]{0, 0, 3, 2};
        System.out.println(dominantIndex(array));
        System.out.println(dominantIndex(array2));
        System.out.println(dominantIndex(array3));
    }


    public static int dominantIndex(int[] nums) {
        if (nums.length == 1)
            return -1;

        int max = 0;
        int secondMax = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else {
                if (secondMax < nums[i])
                    secondMax = nums[i];
            }
        }
        if (max / 2 >= secondMax)
            return index;

        return -1;

    }


}
