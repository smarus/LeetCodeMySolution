package easy.arrays;

import java.util.Arrays;

public class Leet1089 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        //  int[] array = new int[]{1,2,3};
        duplicateZeros(array);
        for (int a : array) {
            System.out.println(a);
        }
    }

    public static void duplicateZeros(int[] arr) {
        int[] B = new int[arr.length];
        Arrays.fill(B, 0);
        int i = 0;
        int i2 = 0;
        while (i2 < arr.length) {
            if (arr[i] != 0) {
                B[i2++] = arr[i++];
            } else {
                i2 += 2;
                i++;
            }
        }

        for (int j = 0; j < B.length; j++) {
            arr[j] = B[j];
        }
    }

}
