package yandex_contest.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PairSum {
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


        int i = 0, j = 0, count = 0;
        while (i < first || j < second) {
            if (j == second || (i < first && firstArray[i] == secondArray[j])) {
                i++;
                count++;
            } else {
                j++;

            }
        }

//        for ( j = 0; j < second; j++) {
//            int c = 0;
//            while (i < first && firstArray[i]== secondArray[j]){
//                i++;
//                c++;
//            }
//            count+=i;
//        }


        System.out.print(count);


    }
}
