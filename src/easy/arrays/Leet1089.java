package easy.arrays;

import java.util.Arrays;

public class Leet1089 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(array);
        for (int a : array) {
            System.out.println(a);
        }
    }

    public static void duplicateZeros(int[] arr) {
        int[] B = new int[arr.length];
        Arrays.fill(B, 0);
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] != 0) {
                B[i] = arr[i];
                i++;
            } else {
                i += 2;
            }
        }

        for (int j = 0; j < B.length; j++) {
            arr[j] = B[j];
        }
    }

}
