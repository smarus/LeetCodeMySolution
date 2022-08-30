package cses.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BinaryLeft {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nk = reader.readLine();

        int[] input = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] k = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < k.length; i++) {
            System.out.println(isExist(input, k[i]) + 1);
        }

    }

    public static int isExist(int[] numbers, int k) {
        int left = -1;
        int right = numbers.length;

        while (right > left + 1) {
            int mid = (left + right) / 2;
            if (numbers[mid] < k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
