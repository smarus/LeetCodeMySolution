package leetcode.easy.arrays;

public class Leet766 {

    public static void main(String[] args) {

    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == matrix[j][i]) {
                    if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j])
                        return false;
                }
            }

        }
        return true;
    }

}
