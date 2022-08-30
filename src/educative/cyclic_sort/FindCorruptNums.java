package educative.cyclic_sort;

import java.util.Arrays;


//We are given an unsorted array containing ‘n’
//        numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to
//‘n’, but due to a data error, one of the numbers
//        got duplicated which also resulted in one number going missing. Find both these numbers.
public class FindCorruptNums {
    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 5, 2}; // 2, 4
        int[] array1 = new int[]{3, 1, 2, 3, 6, 4}; //3
        System.out.println(Arrays.toString(findNumbers(array)));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(findNumbers(array1)));
        System.out.println(Arrays.toString(array1));
    }

    public static int[] findNumbers(int[] nums) {
        int i = 0;
        int[] result = new int[2];
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }


        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result[0] = nums[j];
                result[1] = j + 1;
            }
        }
        return result;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
