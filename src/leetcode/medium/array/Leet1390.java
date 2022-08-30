package leetcode.medium.array;

public class Leet1390 {

    public static void main(String[] args) {
        int[] array = new int[]{21, 4, 7};
        System.out.println(sumFourDivisors(array));
    }

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length == 0)
            return sum;
        for (int num : nums) {
            if (num == 1) {
                continue;
            }
            int divisors = 0;
            int minSum = 1 + num;
            for (int i = 2; i <= ((int) (Math.sqrt(num) + 1)); i++) {
                if (num % i == 0) {
                    minSum += num / i;
                    if (i != num) {
                        minSum += i;
                    }

                    divisors++;
                }
                if (divisors == 1) break;
            }

            if (divisors == 1) {
                sum += minSum;
            }
        }
        return sum;
    }
}
