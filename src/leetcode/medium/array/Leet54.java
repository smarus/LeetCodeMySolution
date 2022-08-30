package leetcode.medium.array;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Leet54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(matrix);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int startColumn = 0, endColumn = matrix[0].length - 1;
        int startRow = 0, endRow = matrix.length - 1;

        List<Integer> list = new ArrayList();

        while (startRow <= endRow && startColumn <= endColumn) {

            StdOut.println("startRow-" + startRow + " endRow-" + endRow);
            StdOut.println("startColumn-" + startColumn + " endColumn-" + endColumn);
            for (int i = startColumn; i <= endColumn; i++) {
                list.add(matrix[startRow][i]);
            }

            for (int i = startRow + 1; i < endRow + 1; i++) {
                list.add(matrix[i][endColumn]);
            }

            for (int i = endColumn - 1; i >= startColumn; i--) {
                list.add(matrix[endRow][i]);
            }

            for (int i = endRow - 1; i >= startRow + 1; i--) {
                list.add(matrix[i][startColumn]);
            }
            startColumn++;
            endColumn--;
            startRow++;
            endRow--;
        }

        return list;
    }
}
