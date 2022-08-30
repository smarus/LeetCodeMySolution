package educative.cyclic_sort;

import java.util.Arrays;

public class FindDuplicate {

    //    We are given an unsorted array containing ‘n+1’ numbers
//    taken from the range 1 to ‘n’. The array has only one
//    duplicate but it can be repeated multiple times.
//    Find that duplicate number without using any extra space.
//    You are, however, allowed to modify the input array.
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 4, 3, 2}; // 4
        int[] array1 = new int[]{2, 1, 3, 3, 5, 4}; //3
        int[] array2 = new int[]{2, 4, 1, 4, 4}; //4
        System.out.println(findNumber(array));
        System.out.println(Arrays.toString(array));
        System.out.println(findNumber(array1));
        System.out.println(Arrays.toString(array1));
        System.out.println(findNumber(array2));
        System.out.println(Arrays.toString(array2));


    }

    public static int findNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }

        return nums.length;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
