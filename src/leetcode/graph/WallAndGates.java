package leetcode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WallAndGates {


    public static void main(String[] args) {
        int[][] matrix = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
//        [[3,-1,0,1],
//        [2,2,1,-1],
//        [1,-1,2,-1],
//        [0,-1,3,4]]

        int[][] matrix2 = new int[][]{{2147483647, 0, 2147483647, 2147483647, 0, 2147483647, -1, 2147483647}};


        wallsAndGates(matrix);
        wallsAndGates(matrix2);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0)
            return;


        int[][] dimensions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j, 0});
                    System.out.println("row: " + i + " col " + j);
                }
            }
        }
        System.out.println(queue.size());
        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] currentGate = queue.poll();
                int row = currentGate[0];
                int col = currentGate[1];
                int step = currentGate[2];

                for (int[] dimension : dimensions) {
                    int newRow = row + dimension[0];
                    int newCol = col + dimension[1];
                    int newStep = step + 1;

                    if (!isCellPossible(newRow, newCol, rooms))
                        continue;

                    rooms[newRow][newCol] = Math.min(newStep, rooms[newRow][newCol]);
                    queue.offer(new int[]{newRow, newCol, newStep});
                }

            }
        }

    }

    public static boolean isCellPossible(int i, int j, int[][] rooms) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length)
            return false;

        if (rooms[i][j] == 0 || rooms[i][j] == -1 || rooms[i][j] != Integer.MAX_VALUE)
            return false;

        return true;
    }
}
