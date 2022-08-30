package Harman;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int n = Integer.parseInt(myObj.nextLine());  // Read user input
        long[] dp = new long[n + 1];
        dp[1] = 0;
        long min;
        for (int i = 2; i <= n; i++) {
            min = dp[i - 1] + 1;
            if (i % 2 == 0) min = Math.min(min, dp[i / 2] + 1);
            if (i % 3 == 0) min = Math.min(min, dp[i / 3] + 1);
            dp[i] = min;
        }

        System.out.println(dp[n]);

    }

}
