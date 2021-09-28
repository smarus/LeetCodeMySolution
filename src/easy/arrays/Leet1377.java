package easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}};
        System.out.println(Arrays.toString(kWeakestRows(matrix, 2)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < mat.length; i++) {
            int sol = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    sol++;
                }
            }
            list.add(sol);

        }

        int[] array = new int[k];
        List<Integer> copy = new ArrayList(list);
        Collections.sort(copy);
        int b = 0;
        for (int i = 0; i < k; i++) {
            int index = getValue(copy.get(i), list);
            array[b++] = index;
        }
        copy = null;
        list = null;
        return array;
    }

    public static int getValue(int value, List<Integer> list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                index = i;
                break;
            }
        }
        list.remove(index);
        return index;
    }
}
