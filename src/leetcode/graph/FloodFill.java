package leetcode.graph;

import java.util.*;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        // int [][] result = floodFill(image, sr, sc, newColor);
        // int [][] result = floodFillIterative(image, sr, sc, newColor);
        int[][] result = floodFillIterativeBFS(image, sr, sc, newColor);

        for (int[] result1 : image) {
            System.out.println(Arrays.toString(result1));
        }


    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        recursive(image, sr, sc, newColor);

        return image;
    }


    public static void recursive(int[][] image, int sr, int sc, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }

        if (image[sr][sc] == 0 || image[sr][sc] == newColor)
            return;

        image[sr][sc] = newColor;
        recursive(image, sr + 1, sc, newColor);
        recursive(image, sr - 1, sc, newColor);
        recursive(image, sr, sc + 1, newColor);
        recursive(image, sr, sc - 1, newColor);
    }

    public static int[][] floodFillIterative(int[][] image, int sr, int sc, int newColor) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});
        int[][] dimensions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            image[cell[0]][cell[1]] = newColor;

            for (int[] dimension : dimensions) {
                int r = cell[0] + dimension[0];
                int c = cell[1] + dimension[1];

                if (!isCellUsable(image, r, c, newColor))
                    continue;

                stack.push(new int[]{r, c});
            }

        }

        return image;
    }

    public static int[][] floodFillIterativeBFS(int[][] image, int sr, int sc, int newColor) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.push(new int[]{sr, sc});
        int[][] dimensions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            image[cell[0]][cell[1]] = newColor;

            for (int[] dimension : dimensions) {
                int r = cell[0] + dimension[0];
                int c = cell[1] + dimension[1];

                if (!isCellUsable(image, r, c, newColor))
                    continue;

                queue.push(new int[]{r, c});
            }

        }

        return image;
    }

    public static boolean isCellUsable(int[][] image, int sr, int sc, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return false;
        }

        if (image[sr][sc] == 0 || image[sr][sc] == newColor)
            return false;


        List<Integer> intersection = new ArrayList();
        intersection.toArray();
        return true;
    }
}
