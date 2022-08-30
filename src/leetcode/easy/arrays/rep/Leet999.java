package leetcode.easy.arrays.rep;

public class Leet999 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int bishPositionW = 0;
        int bishPositionH = 0;
        int pawns = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    bishPositionH = i;
                    bishPositionW = j;
                }
            }
        }

        for (int i = bishPositionW; i >= 0; i--) {
            if (board[bishPositionH][i] == 'B') {
                break;
            } else if (board[bishPositionH][i] == 'p') {
                pawns++;
                break;
            }
        }

        for (int i = bishPositionW; i <= board.length; i++) {
            if (board[bishPositionH][i] == 'B') {
                break;
            } else if (board[bishPositionH][i] == 'p') {
                pawns++;
                break;
            }
        }

        for (int i = bishPositionH; i >= 0; i--) {
            if (board[i][bishPositionW] == 'B') {
                break;
            } else if (board[i][bishPositionW] == 'p') {
                pawns++;
                break;
            }
        }

        for (int i = bishPositionH; i < 8; i++) {
            if (board[i][bishPositionW] == 'B') {
                break;
            } else if (board[i][bishPositionW] == 'p') {
                pawns++;
                break;
            }
        }
        return pawns;

    }


}
