package medium.array;

import java.util.Arrays;

public class Leet912 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 1};
        Leet912 leet912 = new Leet912();
        leet912.sortArray(array);
        System.out.println(Arrays.toString(array));
    }


    public int[] sortArray(int[] nums) {
        int[] aux = new int[nums.length];
        sort(nums, aux, 0, nums.length - 1);
        return nums;
    }

    public void merge(int[] nums, int[] aux, int lo, int mid, int hi) {

        for (int k = 0; k < aux.length; k++) {
            aux[k] = nums[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                nums[k] = aux[j++];
            else if (j > hi)
                nums[k] = aux[i++];
            else if (aux[j] < aux[i])
                nums[k] = aux[j++];
            else
                nums[k] = aux[i++];

            System.out.println(nums[k] + " --- ");
        }

    }

    public void sort(int[] real, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(real, aux, lo, mid);
        sort(real, aux, mid + 1, hi);
        merge(real, aux, lo, mid, hi);
    }


}
