package leetcode.easy.arrays;

public class Leet999 {

    //On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.
    // These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
    // and lowercase characters represent black pieces.
    //
    //The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
    // then moves in that direction until it chooses to stop, reaches the edge of the board, or captures
    // an opposite colored pawn by moving to the same square it occupies.
    // Also, rooks cannot move into the same square as other friendly bishops.
    //
    //Return the number of pawns the rook can capture in one move.
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
        int bishPositionH = 0;
        int bishPositionW = 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    bishPositionH = j;
                    bishPositionW = i;
                }
            }
        }


        for (int i = bishPositionH; i < 8; i++) {
            if (board[i][bishPositionH] == 'B') {
                break;
            } else if (board[i][bishPositionH] == 'p') {
                count++;
                break;
            }

        }
        for (int i = bishPositionH; i >= 0; i--) {
            if (board[i][bishPositionH] == 'B') {
                break;
            } else if (board[i][bishPositionH] == 'p') {
                count++;
                break;
            }
        }

        for (int i = bishPositionW; i < 8; i++) {
            if (board[bishPositionW][i] == 'B') {
                break;
            } else if (board[bishPositionW][i] == 'p') {
                count++;
                break;
            }

        }
        for (int i = bishPositionW; i >= 0; i--) {
            if (board[bishPositionW][i] == 'B') {
                break;
            } else if (board[bishPositionW][i] == 'p') {
                count++;
                break;
            }
        }


        return count;
    }
}
