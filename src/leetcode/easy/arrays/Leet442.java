package leetcode.easy.arrays;
//Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements that appear twice in this array.

import java.util.*;

// Could you do it without extra space and in O(n) runtime?
public class Leet442 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> integers = findDuplicates(array);
        for (Integer integer : integers)
            System.out.println(integer);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.fill(count, 0);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i]  " + nums[i]);
            count[nums[i] - 1]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 2) res.add(i + 1);
        }
        return res;
    }
}
