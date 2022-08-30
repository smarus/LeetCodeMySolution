package abstractData;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] ints = new int[]{5, 2, 3, 1, 4, 6};
        System.out.println(Arrays.toString(sort(ints)));


    }


    public static int[] sort(int[] array) {
        if (array.length <= 1)
            return array;

        int pivotIndex = array.length / 2;
        int[] leftSubArray = sort(Arrays.copyOfRange(array, 0, pivotIndex));
        System.out.println(Arrays.toString(leftSubArray));
        int[] rightSubArray = sort(Arrays.copyOfRange(array, pivotIndex, array.length));
        System.out.println(Arrays.toString(rightSubArray));
        return mergeSubArray(leftSubArray, rightSubArray);
    }


    public static int[] mergeSubArray(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int res = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[res++] = left[l++];
            } else {
                merged[res++] = right[r++];
            }

        }
        while (l < left.length) {
            merged[res++] = left[l++];
        }
        while (r < right.length) {
            merged[res++] = right[r++];
        }

        return merged;
    }
}
