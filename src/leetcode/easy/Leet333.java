package leetcode.easy;

import java.util.Scanner;

public class Leet333 {
    private static int[] coins = new int[]{10, 6, 1};

    public static void main(String[] args) {
//        System.out.println(makeChange(49));
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//
//        int n = Integer.parseInt(myObj.nextLine());  // Read user input
//        long [] array = new long[n+1];
//        long [] dp = new long[n+1];
//        String []st = myObj.nextLine().split(" ");
//        int b = 1;
//        for(int i = 0;i<st.length;i++){
//            array[b++] = Long.parseLong(st[i]);
//        }
//        dp[0] = 0;
//        dp[1] = array[1];
//        for(int i = 2; i<=n;i++){
//            dp[i] = Math.max(dp[i-1], dp[i - 2]) + array[i];
//        }
//
//        System.out.println(dp[n]);
        dynamic();
    }

    //i + 1 i+1, i + 3i+3, i + 5i+5
    public static void dynamic() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int n = Integer.parseInt(myObj.nextLine());  // Read user input
        long[] array = new long[n + 5];
        long[] dp = new long[n + 5];
        String[] st = myObj.nextLine().split(" ");
        int b = 1;
        for (int i = 0; i < st.length; i++) {
            array[b++] = Long.parseLong(st[i]);
        }
        dp[0] = 0;
        dp[1] = array[1];
        dp[2] = Math.max(dp[0], dp[1]) + array[2];
        dp[3] = Math.max(dp[1], dp[2]) + array[3];
        dp[4] = Math.max(dp[2], dp[3]) + array[4];
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 3]), dp[i - 4]) + array[i];
        }

        System.out.println(dp[n]);
    }


    public static int makeChange(int c) {
        if (c == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
// Try removing each coin from the total and //
// see how many more coins are required
        for (int coin : coins) {
            // Skip a coin if it’s value is greater
            // than the amount remaining
            if (c - coin >= 0) {
                int currMinCoins = makeChange(c - coin);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
        // Add back the coin removed recursively
        return minCoins + 1;
    }


}

