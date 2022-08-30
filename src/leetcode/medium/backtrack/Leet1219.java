package leetcode.medium.backtrack;

import java.util.Arrays;

public class Leet1219 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        int[][] array2 = new int[][]{
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}};

        System.out.println(getMaximumGold(array));
        System.out.println(getMaximumGold(array2));
    }

    public static int getMaximumGold(int[][] grid) {

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0)
                    maxValue = Math.max(helper(i, j, grid), maxValue);
            }
        }


        return maxValue;

    }

    public static int helper(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;

        if (grid[i][j] == 0)
            return 0;

        int value = grid[i][j];
        grid[i][j] = 0;

        int result = Math.max(
                Math.max(helper(i + 1, j, grid), helper(i - 1, j, grid)),
                Math.max(helper(i, j + 1, grid), helper(i, j - 1, grid)));
        grid[i][j] = value;
        return result + value;
    }
}
