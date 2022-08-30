package educative.two_pointer;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2, 1, 0};
        int[] array2 = new int[]{2, 2, 0, 1, 2, 0};

        sort(array);
        sort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }

    public static void sort(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        int i = 0;
        while (i <= hi) {
            if (arr[i] == 0) {
                swap(arr, i, lo);
                lo++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, hi);
                hi--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
