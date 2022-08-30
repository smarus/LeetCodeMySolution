package leetcode.easy.arrays;

public class Leet463 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(grid));

    }

    public static int islandPerimeter(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        count++;
                    }
                    if (j == 0) {
                        count++;
                    }

                    if (i == grid.length - 1)
                        count++;

                    if (j == grid.length - 1)
                        count++;

                    if (i > 0 && j > 0 && j < grid[i].length - 1 && i < grid.length - 1) {
                        if (grid[i - 1][j] == 0) {
                            count++;
                        }
                        if (grid[i + 1][j] == 0)
                            count++;

                        if (grid[i][j - 1] == 0) {
                            count++;
                        }
                        if (grid[i][j + 1] == 0)
                            count++;
                    }


                }
            }
        }

        return count;
    }
}
