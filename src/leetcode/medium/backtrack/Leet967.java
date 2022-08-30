package leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
//        Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
//
//        You may return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: n = 3, k = 7
//        Output: [181,292,707,818,929]
//        Explanation: Note that 070 is not a valid number, because it has leading zeroes.
//        Example 2:
//
//        Input: n = 2, k = 1
//        Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
public class Leet967 {
    int k = 1;

    public static void main(String[] args) {
        int[] buffer = new int[2];
        StringBuilder sb = new StringBuilder(2);
        List<Integer> list = new ArrayList<>();
        backtrack(0, buffer, list);
        System.out.println(list);
    }

//    public int[] numsSameConsecDiff(int n, int k) {
//
//    }


    public static void backtrack(int index, int[] buffer, List<Integer> total) {
        if (index == buffer.length) {
            if (buffer[0] != 0) {
                int exponent = 1;
                int number = 0;
                for (int i = buffer.length - 1; i >= 0; i--) {
                    number = (exponent * buffer[i]) + number;
                    exponent *= 10;
                }
                total.add(number);

            }
            return;
        } else {
            for (int i = 0; i < 10; i++) {
                buffer[index] = i;
                if (index > 0 && Math.abs(buffer[index - 1] - buffer[index]) != 1) {
                    continue;
                } else {
                    backtrack(index + 1, buffer, total);
                }
            }
        }
    }
}
