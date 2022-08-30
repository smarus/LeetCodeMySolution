package leetcode.medium.dp;

public class Leet64 {
    public static void main(String[] args) {
        int[][] sum = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(sum));
    }

    public static int minPathSum(int[][] grid) {
        int i = grid.length - 1;
        int j = grid[i].length - 1;
        int[][] memo = new int[grid.length][grid[0].length];
        for (int k = 0; k < memo.length; k++) {
            for (int l = 0; l < memo[i].length; l++) {
                memo[k][l] = -1;
            }
        }
        return helper(grid, i, j, memo);
    }

    public static int helper(int[][] grid, int i, int j, int[][] memo) {
        if (i == 0 && j == 0)
            return grid[0][0];

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if (memo[i][j] != -1)
            return memo[i][j];
        int result = Math.min(helper(grid, i - 1, j, memo), helper(grid, i, j - 1, memo)) + grid[i][j];
        memo[i][j] = result;
        return result;
    }


}
