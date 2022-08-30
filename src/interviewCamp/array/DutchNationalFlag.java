package interviewCamp.array;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 5, 4, 4, 6, 2, 3};
        int i = 0;
        int pivot = 4;
        int left = 0;
        int right = array.length - 1;

        while (i <= right) {
            if (array[i] < pivot) {
                swap(array, i, left);
                left++;
                i++;
            } else if (array[i] > pivot) {
                swap(array, right, i);
                right--;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(array));
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
