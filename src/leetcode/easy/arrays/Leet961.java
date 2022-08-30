package leetcode.easy.arrays;

import java.util.Arrays;

//In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
//Return the element repeated N times.
//Input: [1,2,3,3]
//        Output: 3
public class Leet961 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 3};
        int[] B = new int[]{2, 1, 2, 5, 3, 2};
        int[] C = new int[]{5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(repeatedNTimes(A));
        System.out.println(repeatedNTimes(B));
        System.out.println(repeatedNTimes(C));
    }


    public static int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                return A[i];
            }
        }
        return 0;
    }
}
