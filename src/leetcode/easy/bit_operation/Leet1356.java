package leetcode.easy.bit_operation;

import java.util.Arrays;

public class Leet1356 {

    public static void main(String[] args) {
        int x = 5;

//        System.out.println(x & ~(x-1));
//        System.out.println(x & (x + (1 << 2)));
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] array2 = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};


        //   System.out.println(Arrays.toString(sortByBits(array)));
        System.out.println(Arrays.toString(sortByBits(array2)));

    }

    public static int[] sortByBits(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (getBitCount(arr[j]) > getBitCount(arr[j + 1])) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        return arr;

    }

    private static int getBitCount(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


}
