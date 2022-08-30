package leetcode.easy.binara_search;

class GuessGame {
    int guess(int n) {
        return -1;
    }
}

public class Leet374 extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= n) {
            int mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1) {
                lo = mid + 1;
            } else if (guess(mid) == -1) {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
