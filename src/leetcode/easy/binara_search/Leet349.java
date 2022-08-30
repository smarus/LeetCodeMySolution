package leetcode.easy.binara_search;

import java.util.*;

public class Leet349 {
    public static void main(String[] args) {


        int[] array = new int[]{1, 2, 2, 1};
        int[] array1 = new int[]{2, 2};
        int[] array2 = new int[]{4, 9, 5};
        int[] array3 = new int[]{9, 4, 9, 8, 4};
        int[] arr = intersection(array, array1);
        int[] arr1 = intersection(array2, array3);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

//        if (nums1.length == nums2.length){
//           return nums1;
//        }
//            int [] array = new int[nums1.length + nums2.length];
//            int index = 0;
//            Set<Integer> set = new HashSet<>();
//
//        for(int num : nums1){
//           if (binarySearch(nums2,num) != -1){
//               array[index] = num;
//               set.add(num);
//               index++;
//
//           }
//        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        Iterator<Integer> i = set1.iterator();
        int index = 0;
        int[] returnArray = new int[set1.size()];
        while (i.hasNext()) {
            returnArray[index++] = i.next();
        }

        return returnArray;
    }

    private static int binarySearch(int[] array, int value) {
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int middle = min + (max - min) / 2;
            if (array[middle] == value)
                return middle;
            if (array[middle] > value)
                min = middle + 1;
            else if (array[middle] < value)
                max = middle - 1;
        }
        return -1;
    }
}
