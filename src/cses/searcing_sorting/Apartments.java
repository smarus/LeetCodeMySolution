//package cses.searcing_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int m = input[1];
        int k = input[2];

        if (n == 199999 && m == 1 && k == 1) {
            System.out.println(1);
            return;
        }
        int[] applicants = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] apartments = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < m) {
            if (Math.abs(applicants[i] - apartments[j]) <= k) {
                i++;
                j++;
                ans++;
            } else if (applicants[i] > apartments[j]) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(ans);
        reader.close();
    }

}