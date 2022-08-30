

import java.util.Arrays;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        int[] array = new int[TC];
        int index = 0;
        while (TC-- > 0) {
            array[index] = scanner.nextInt();
            index++;
        }
        Arrays.sort(array);

        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] != array[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
}
