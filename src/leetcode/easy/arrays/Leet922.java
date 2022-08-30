package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet922 {
    public static void main(String[] args) {
        int[] arrayd = new int[]{4, 2, 5, 7};
        int[] array = sortArrayByParityII(arrayd);
        System.out.println(Arrays.toString(array));

    }


    public static int[] sortArrayByParityII(int[] A) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                even.add(A[i]);
            else
                odd.add(A[i]);
        }

        int eveIndex = 0;
        int oddIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = even.get(eveIndex);
                eveIndex++;
            } else {
                A[i] = odd.get(oddIndex);
                oddIndex++;
            }
        }

        return A;
    }
}

//
//    class Solution {
//        public int[] sortArrayByParityII(int[] A) {
//            int i = 0, j = 1, n = A.length;
//            while (i < n && j < n) {
//                while (i < n && A[i] % 2 == 0) {
//                    i += 2;
//                }
//                while (j < n && A[j] % 2 == 1) {
//                    j += 2;
//                }
//                if (i < n && j < n) {
//                    swap(A, i, j);
//                }
//            }
//            return A;
//        }
//        private void swap(int[] A, int i, int j) {
//            int temp = A[i];
//            A[i] = A[j];
//            A[j] = temp;
//        }
//    }
//}
