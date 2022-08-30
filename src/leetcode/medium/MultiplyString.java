package leetcode.medium;

import java.util.Arrays;

public class MultiplyString {

    public static void main(String[] args) {
        System.out.println(multiply("999", "999"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0"))
            return "0";


        int[] result = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int num = num1.charAt(i) - '0';
                int nu = num2.charAt(j) - '0';
                result[i + j] += num * nu;
            }
        }


        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
        for (int num : result) {
            sb.append(num);
        }

        return sb.toString();
    }
}
