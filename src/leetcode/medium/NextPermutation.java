package leetcode.medium;

import java.util.Arrays;

public class NextPermutation {


    public static void main(String[] args) {


        // Find longest non-increassing suffix
        int[] array = new int[]{0, 1, 2, 5, 3, 3, 0};

        int i = array.length - 1;

        while (i > 0 && array[i] <= array[i - 1]) {
            i--;
        }

        // Find rightmost element greater than the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        System.out.println(array[j]);
        System.out.println(array[i]);

        // Swap with the pivot
        int temp = array[j];
        array[j] = array[i - 1];
        array[i - 1] = temp;

        //Reverse Suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(array));


    }

    boolean previousPermutation(int[] array) {
        // Find longest non-decreasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] <= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the first permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element less than the pivot
        int j = array.length - 1;
        while (array[j] >= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the previous permutation
        return true;
    }
}
