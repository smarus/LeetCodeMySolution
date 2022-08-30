package leetcode;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 5, 1, 2, 7, 3, 9};

        // System.out.println(Arrays.toString(sort(array)));
        quickSortFirst(array);
        System.out.println(Arrays.toString(array));
    }


    public static int[] sort(int[] arr) {
        if (arr.length <= 1)
            return arr;

        int mid = arr.length / 2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int mergedIndex = 0;
        int l = 0;
        int r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[mergedIndex++] = left[l++];
            } else {
                merged[mergedIndex++] = right[r++];
            }
        }

        while (l < left.length) {
            merged[mergedIndex++] = left[l++];
        }

        while (r < right.length) {
            merged[mergedIndex++] = right[r++];
        }

        return merged;
    }


    public static void quickSortFirst(int[] array) {
        quickSort(array, 0, array.length - 1);

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;

        int pivot = array[left + (right - left) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot)
                right--;


            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
