package medium.array;

public class Leet926 {
    //Prefix sum method for checking solved with help
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("010110"));

    }

    public static int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N - j - (P[N] - P[j]));
        }

        return ans;
    }
}
