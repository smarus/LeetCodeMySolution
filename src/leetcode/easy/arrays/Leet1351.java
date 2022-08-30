package leetcode.easy.arrays;

public class Leet1351 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        countNegatives(grid);
    }

    public static int countNegatives(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0)
                    sum++;
            }
        }
        return sum;
    }
}

