package leetcode.easy.binara_search;

public class Leet258 {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(99));
    }

    public static int addDigits(int num) {
        while (num > 9) {
            num = sumOfDigit(num);
        }
        return num;
    }

    static int sumOfDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
