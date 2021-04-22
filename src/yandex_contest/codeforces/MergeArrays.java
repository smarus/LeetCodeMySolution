package yandex_contest.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MergeArrays {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String[] p = in.readLine().split("\\s");
        int first = Integer.parseInt(p[0]);
        int second = Integer.parseInt(p[1]);
        int[] firstArray = new int[first];
        int[] secondArray = new int[second];
        String[] f = in.readLine().split("\\s");
        String[] s = in.readLine().split("\\s");

        for (int i = 0; i < first; i++) {
            firstArray[i] = Integer.parseInt(f[i]);
        }
        for (int i = 0; i < second; i++) {
            secondArray[i] = Integer.parseInt(s[i]);
        }

        int[] third = new int[first + second];

        int i = 0, j = 0;
        while (i < first || j < second) {
            if (j == second || (i < first && firstArray[i] < secondArray[j])) {
                third[i + j] = firstArray[i];
                i++;
            } else {
                third[i + j] = secondArray[j];
                j++;
            }
        }

        for (int k = 0; k < third.length; k++) {
            System.out.print(third[k] + " ");
        }


    }
}
