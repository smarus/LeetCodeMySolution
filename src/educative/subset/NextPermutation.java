package educative.subset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextPermutation {

//    Find largest index i such that array[i − 1] < array[i].
//            (If no such i exists, then this is already the last permutation.)
//
//    Find largest index j such that j ≥ i and array[j] > array[i − 1].
//
//    Swap array[j] and array[i − 1].
//
//    Reverse the suffix starting at array[i].


    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3};
        Map<Character, Integer> freqMap = new HashMap<>();


        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;

        // Let array[i - 1] be the pivot

        // Find rightmost element greater than the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Swap the pivot with j
        swap(array, i - 1, j);

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }

        System.out.println(Arrays.toString(array));


    }


    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
