package easy.two_pointer;

import java.util.Arrays;

public class Leet27 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3};
        int[] array2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(removeElement(array2,2));
//        System.out.println(Arrays.toString(array2));
        //   System.out.println(removeElement(array,3));
        System.out.println(Arrays.toString(array));

    }

    //Better solution than my
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            while (A[i] == elem && i < len) {
                A[i] = A[--len];
            }
        }
        return len;
    }

//    public static int removeElement(int[] nums, int val) {
//        int j = nums.length -1 ;
//        int i = 0;
//        int count = 0;
//        while (i< j){
//            if (nums[i] == val){
//                nums[i] = 0;
//                count++;
//            }
//            if (nums[j] == val){
//                nums[j] = 0;
//                count++;
//            }
//            i++;
//            j--;
//        }
//
//        int index = 0;
//        for (int k = 0; k < nums.length  ; k++) {
//            if (nums[i] != 0)
//                nums[index] = nums[k];
//                index++;
//        }
//
//        return nums.length;
//    }
//
//    private void swap(int [] array , int i , int j){
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//}
