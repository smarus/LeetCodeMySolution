package educative.two_pointer;

import java.util.Arrays;

//Given an array of sorted numbers,
//        remove all duplicates from it.
//        You should not use any extra space;
//after removing the duplicates
//        in-place return the new length of the array.
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 3, 3, 6, 9, 9}; // 4
        int[] array2 = new int[]{2, 2, 2, 11}; // 4
        System.out.println(remove(array));
        System.out.println(Arrays.toString(array));
        System.out.println(remove(array2));

    }

    public static int remove(int[] arr) {
        int pointer = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[pointer - 1]) {
                arr[pointer] = arr[i];
                pointer++;
            }
        }
        return pointer;
    }
}
