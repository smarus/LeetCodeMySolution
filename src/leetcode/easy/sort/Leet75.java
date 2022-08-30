package leetcode.easy.sort;

import java.util.Arrays;

public class Leet75 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n / 2; k >= 1; k--)
            sink(pq, k, n);

        // sortdown phase
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(int[] pq, int i, int j) {
        return pq[i - 1] < pq[j - 1];
    }

    private static void exch(int[] pq, int i, int j) {
        int swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }
}
