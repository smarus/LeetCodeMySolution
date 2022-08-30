package educative.cyclic_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//We are given an unsorted array containing numbers taken from the range
//        1 to ‘n’. The array can have duplicates,
//        which means some numbers will be missing. Find all those missing numbers.
public class AllMisingNumbers {

    public static void main(String[] args) {
        // 4, 6, 7
        int[] array = new int[]{2, 3, 1, 8, 2, 3, 5, 1};

        System.out.println(findNumbers(array));
    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumber = new ArrayList<>();
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
                missingNumber.add(j + 1);
            }
        }

        return missingNumber;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
