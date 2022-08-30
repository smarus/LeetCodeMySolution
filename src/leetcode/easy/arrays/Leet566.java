package leetcode.easy.arrays;
//In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
//
//        You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
//
//        The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
//
//        If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.


public class Leet566 {
    public static void main(String[] args) {
        int[][] newArray = new int[][]{{1, 2}, {3, 4}};
        newArray = matrixReshape(newArray, 1, 4);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println();
            for (int j = 0; j < newArray[i].length; j++) {
                System.out.println(newArray[i][j]);
            }
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] newArray = new int[r][c];
        int[] savedData = new int[nums.length * nums[0].length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                savedData[k] = nums[i][j];
                k++;
            }
        }

        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArray[i][j] = savedData[k];
                k++;
            }
        }
        return newArray;
    }

}

