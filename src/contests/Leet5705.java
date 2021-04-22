package contests;

public class Leet5705 {
    int[][] matrix = new int[][]{
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
    };

//    public static void main(String[] args) {
//        System.out.println(squareIsWhite("a1"));
//        System.out.println(squareIsWhite("h3"));
//        System.out.println(squareIsWhite("c7"));
//    }

    public boolean squareIsWhite(String coordinates) {
        int vertical = Character.getNumericValue(coordinates.charAt(1)) - 1;
        int horizontal = coordinates.charAt(0) - 'a';
        System.out.println(matrix[vertical][horizontal] + " horizontal" + horizontal + " vertical" + vertical);
        return matrix[vertical][horizontal] == 0;
    }
}
