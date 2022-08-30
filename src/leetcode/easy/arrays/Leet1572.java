package leetcode.easy.arrays;

public class Leet1572 {

    public static void main(String[] args) {

        int[][] mat = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int k = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            int c = mat[i].length - 1;
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    System.out.println(i + " i ---j  " + j);
                    sum += mat[i][j];
                }
                if (k == c) {
                    sum += mat[k][c];
                    System.out.println(k + " k ---c  " + c);

                }
                c--;
            }
            k--;

        }
        return sum;
    }
}
