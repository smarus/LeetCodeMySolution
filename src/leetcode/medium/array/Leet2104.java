package leetcode.medium.array;

import java.util.PriorityQueue;

public class Leet2104 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3}; // 4
        // 1 - 2 = 1
        // 2 - 3 = 1
        // 1- 3 =  2
        int[] nums2 = new int[]{1, 3, 3}; //4
        int[] nums3 = new int[]{4, -2, -3, 4, 1};// 59;
        System.out.println(countSubArray(nums));
        System.out.println(countSubArray(nums2));
        System.out.println(countSubArray(nums3));
    }

    public static int countSubArray(int[] nums) {
        int count = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        int left = 0;
        int right = 0;

        while (left < right || right < nums.length) {

            if (right < nums.length) {
                int num = nums[right];
                min.offer(num);
                max.offer(num);
                right++;
            } else {
                int num = nums[left];
                min.remove(num);
                max.remove(num);
                left++;
            }

            if (!max.isEmpty() || !min.isEmpty())
                count += max.peek() - min.peek();
        }

        return count;

    }
}
