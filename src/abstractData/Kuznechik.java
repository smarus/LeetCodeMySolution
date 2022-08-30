package abstractData;

import java.util.Scanner;

public class Kuznechik {

    //
    public static void main(String[] args) {
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
        for (int i = 2; i <= n; i++) {
            long max1 = Math.max(dp[i - 1], i - 3 < 0 ? dp[i - 1] : dp[i - 3]);
            long max2 = i - 5 < 0 ? dp[i - 1] : dp[i - 5];
            dp[i] = Math.max(max1, max2) + array[i];
        }

        System.out.println(dp[n]);
    }
}
