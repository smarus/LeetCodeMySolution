package cses.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Binary {

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
            if (isExist(input, k[i]))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    public static boolean isExist(int[] numbers, int k) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == k)
                return true;

            if (k < numbers[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
