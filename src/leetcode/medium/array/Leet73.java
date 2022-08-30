package leetcode.medium.array;

public class Leet73 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {

        outerloop:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setZero(matrix, i, j);
                    break outerloop;
                }
            }
        }
    }

    public static void setZero(int[][] matrix, int row, int col) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = 0;
            }
        }


        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = 0;
            }
        }
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
