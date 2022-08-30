package abstractData;

public class QueensProblem {

    public int[][] chessTable;
    public int numOfQueens;

    public QueensProblem(int numOfQueens) {
        this.chessTable = new int[numOfQueens][numOfQueens];
        this.numOfQueens = numOfQueens;
    }

    public void solve() {
        if (setQueens(0))
            printQueens();
        else
            System.out.println("There is no solution ....");
    }

    private boolean setQueens(int collIndex) {
        //Base case
        if (collIndex == numOfQueens)
            return true;

        for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
            if (isPlaceValid(rowIndex, collIndex)) {
                chessTable[rowIndex][collIndex] = 1;
                if (setQueens(collIndex + 1))
                    return true;
                //BackTrack
                chessTable[rowIndex][collIndex] = 0;
            }

        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int collIndex) {
        for (int i = 0; i < collIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                return false;
            }
        }

        for (int i = rowIndex, j = collIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessTable[i][j] == 1)
                return false;
        }

        for (int i = rowIndex, j = collIndex; i < chessTable.length && j >= 0; i++, j--) {
            if (chessTable[i][j] == 1)
                return false;
        }

        return true;
    }

    private void printQueens() {
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable.length; j++) {
                if (chessTable[i][j] == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


}
