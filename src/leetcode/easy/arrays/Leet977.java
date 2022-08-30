package leetcode.easy.arrays;

import java.util.Arrays;

//Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
public class Leet977 {

    public static void main(String[] args) {
        int[] A = new int[]{-4, -1, 0, 3, 10};
        int[] B = new int[]{-7, -3, 2, 3, 11};
        int[] C = sortedSquares(A);
        int[] D = sortedSquares(B);
        for (int i = 0; i < C.length; i++) {
            System.out.print(D[i] + " ");
        }

    }

    public static int[] sortedSquares(int[] A) {

        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }
}
