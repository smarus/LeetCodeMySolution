package yandex_contest.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OtrezokSuma {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String[] p = in.readLine().split("\\s");
        int n = Integer.parseInt(p[0]);
        int s = Integer.parseInt(p[1]);
        String[] string = in.readLine().split("\\s");
        int[] array = new int[n];
        int a = 0;
        for (String str : string) {
            array[a++] = Integer.parseInt(str);
        }
        int res = 0;
        int x = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            x += array[i];
            while (x > s) {
                x -= array[l];
                l++;
            }
            res = Math.max(res, i - l + 1);
        }

        System.out.println(res);
    }
}
