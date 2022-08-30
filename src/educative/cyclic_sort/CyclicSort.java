package educative.cyclic_sort;


import java.util.Arrays;

//We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number
//        from 1 to ‘n’ based on their creation sequence.
//        This means that the object with sequence number ‘3’
//        was created just before the object with sequence number ‘4’.
//
//        Write a function to sort the objects in-place on their creation sequence number in O(n)
//        O(n) and without any extra space. For simplicity, let’s assume we are passed an
//        integer array containing only the sequence numbers, though each number is actually an object.
public class CyclicSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 5, 4, 2};
        int[] array1 = new int[]{2, 6, 4, 3, 1, 5};
        int[] array2 = new int[]{1, 5, 6, 4, 3, 2};
        sort(array);
        System.out.println(Arrays.toString(array));
        sort(array1);
        System.out.println(Arrays.toString(array1));
        sort(array2);
        System.out.println(Arrays.toString(array2));
        String s = "+--- org.bitbucket.b_c:jose4j:0.6.2-OT-WA";
        System.out.println();
    }

    public static void sort(int[] nums) {
        //
        if (nums.length == 0)
            return;

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
