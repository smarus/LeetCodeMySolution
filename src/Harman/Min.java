package Harman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] input = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = input[1][1];

        for (int j = 2; j <= m; j++) {
            dp[1][j] = dp[1][j - 1] + input[1][j];
        }

        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + input[i][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + input[i][j];
            }
        }

        System.out.println(dp[n][m]);


    }
}
