package cses.searcing_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FerrisWheel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        String[] weightsStr = sc.nextLine().split(" ");
        Integer[] weights = new Integer[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(weightsStr[i]);
        }
        Arrays.sort(weights);

        int ans = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            ans++;
            if (i == j) break;
            if (weights[i] + weights[j] <= x) {
                i++;
            }
            j--;
        }
        System.out.println(ans);
    }
}
