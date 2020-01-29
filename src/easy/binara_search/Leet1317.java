package easy.binara_search;

import java.util.Arrays;

public class Leet1317 {
    public static void main(String[] args) {

        System.out.println(isZeroContain(1010));

        System.out.println(Arrays.toString(getNoZeroIntegers(1010)));
        System.out.println(Arrays.toString(getNoZeroIntegers(10000)));

    }

    public static int[] getNoZeroIntegers(int n) {
        int[] nums = new int[2];
        for (int i = 1; i <= n; i++) {
            int number = n - i;
            if (isZeroContain(number) || isZeroContain(i)) {
                continue;
            }
            if (number + i == n) {
                nums[0] = i;
                nums[1] = number;
                break;
            }
        }
        return nums;

    }


    private static boolean isZeroContain(int num) {
        while (num != 0) {
            if (num % 10 == 0) {
                return true;
            }
            num = num / 10;
        }

        return false;
    }
}
