package Harman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kuznes {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int n = Integer.parseInt(myObj.nextLine());  // Read user input
        List<Integer> dp = new ArrayList<>(n);
        String line = myObj.nextLine();


        dp.add(0, 0);
        int base1 = (1 - (line.charAt(0) - '0'));
        dp.add(1, base1);
        int bas3 = line.charAt(1) == '1' ? 0 : dp.get(0) + dp.get(1);
        dp.add(2, bas3);
        int index = 2;
        for (int i = 3; i < line.length() + 1; i++) {

            if (line.charAt(index) == '1')
                dp.add(0);
            else {
                int chislo = (dp.get(i - 1) % 1000000007) + (dp.get(i - 2) % 1000000007) + (dp.get(i - 3) % 1000000007);
                dp.add(chislo);
            }

            index++;
        }
        System.out.println(dp.get(n));

    }

    public static int recursive(String s, int index, int[] dp) {
        if (index < 0)
            return 0;

        if (index == 0)
            return 1;

        if (dp[index] != -1)
            return dp[index];

        if (s.charAt(index) == '1')
            return 0;

        dp[index] = recursive(s, index - 1, dp) + recursive(s, index - 2, dp) + recursive(s, index - 3, dp);
        return dp[index];

    }
}
