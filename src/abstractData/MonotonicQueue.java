package abstractData;

import java.util.*;

public class MonotonicQueue {
    Deque<Integer> deque;

    public MonotonicQueue() {
        deque = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = new int[]{-7, -8, 7, 5, 7, 1, 6, 0};
        int[] result = maxSlidingWindow(nums, 3);
        int[] result2 = maxSlidingWindow(nums2, 4);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];

        if (nums.length == 1 && k == 1)
            return nums;

        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                integers.add(queue.getMax());
                queue.pop(nums[i - k + 1]);
            }
        }

        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }

        return result;

    }

    public void push(int n) {
        while (!deque.isEmpty() && deque.getLast() < n)
            deque.removeLast();
        deque.offerLast(n);
    }

    public int getMax() {
        return deque.peekFirst();
    }

    public void pop(int n) {
        while (!deque.isEmpty() && deque.peekFirst() == n)
            deque.removeFirst();
    }
}


