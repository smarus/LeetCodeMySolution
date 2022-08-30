package leetcode.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Leet884 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] simplyNumber = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113};
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (n > 1) {
            if (n % simplyNumber[i] == 0) {
                list.add(simplyNumber[i]);
                n = n / simplyNumber[i];
            } else {
                i++;
            }
        }
        for (int b : list) {
            System.out.print(b + " ");
        }
    }

    public String[] uncommonFromSentences(String A, String B) {
        return null;
    }
}
