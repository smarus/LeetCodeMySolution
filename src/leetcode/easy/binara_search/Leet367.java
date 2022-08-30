package leetcode.easy.binara_search;

public class Leet367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));

    }

    public static boolean isPerfectSquare(int num) {
        for (int i = 1; i < num; i++) {
            if (i * i == num) {
                return true;

            }
        }
        return false;
    }
}
