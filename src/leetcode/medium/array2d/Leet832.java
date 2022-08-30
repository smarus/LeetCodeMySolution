package leetcode.medium.array2d;

import java.util.Arrays;

public class Leet832 {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        int[][] rotated = flipAndInvertImage(image);

        for (int[] array : rotated) {
            System.out.println(Arrays.toString(array));
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        if (image == null || image.length == 0)
            return image;


        int[][] array = new int[image.length][image[0].length];
        int ri = 0, ry = 0;
        for (int i = 0; i < array.length; ++i) {
            ry = 0;
            for (int j = array[i].length - 1; j >= 0; --j) {
                array[i][ry] = image[i][j];
                ry++;
            }
        }

        for (int[] arrayd : array) {
            System.out.println(Arrays.toString(arrayd));
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }

        return array;
    }
}
