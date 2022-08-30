package leetcode.easy.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Leet1304 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(23)));
    }

    public static int[] sumZero(int n) {

        Random random = new Random();
        Set<Integer> set = new HashSet();
        int max = 100;
        int min = -100;

        while (true) {
            int i = 0;
            while (i < n) {
                int number = random.nextInt(max - min) + min;
                if (!set.contains(number)) {
                    set.add(number);
                    i++;
                }

            }
            if (isSumZero(set))
                break;
            else set.clear();


        }
        int b = 0;
        int[] array = new int[n];
        for (Integer num : set) {
            array[b++] = num;
        }
        return array;
    }

    public static boolean isSumZero(Set<Integer> set) {
        int sum = 0;
        for (Integer num : set) {
            System.out.print(num + " ");
            sum += num;
        }
        System.out.println();
        System.out.println("--------");
        return sum == 0;
    }
}
