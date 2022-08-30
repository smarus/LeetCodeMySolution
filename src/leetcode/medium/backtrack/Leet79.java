package leetcode.medium.backtrack;

import java.util.HashSet;
import java.util.Set;

public class Leet79 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        Set<Character> used = new HashSet<>();
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[0].length; l++) {
                if (boardHelper(board, k, l, 0, used, word)) ;
                return true;
            }
        }
        return false;
    }

    public static boolean boardHelper(char[][] board, int i, int j, int index, Set<Character> used, String word) {
        if (index == word.length())
            return true;
        if (outOfBoundary(board, i, j) ||
                index >= word.length() ||
                board[i][j] != word.charAt(index) ||
                used.contains(board[i][j]))
            return false;


        boardHelper(board, i + 1, j, index + 1, used, word);
        boardHelper(board, i - 1, j, index + 1, used, word);
        boardHelper(board, i, j + 1, index + 1, used, word);
        boardHelper(board, i, j - 1, index + 1, used, word);
        used.remove(board[i][j]);

        return false;
    }

    public static boolean outOfBoundary(char[][] board, int i, int j) {
        return i < 0 || i >= board.length || j < 0 || j >= board[0].length;
    }
}
