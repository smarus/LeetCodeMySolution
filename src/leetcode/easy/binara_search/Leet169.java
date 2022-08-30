package leetcode.easy.binara_search;

//Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.

//Input: [3,2,3]
//        Output: 3

import java.util.HashMap;
import java.util.Map;

//Input: [2,2,1,1,1,2,2]
//        Output: 2
public class Leet169 {
    public static void main(String[] args) {

        int[] times = new int[]{3, 2, 3};
        int[] times2 = new int[]{2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(times));
        System.out.println(majorityElement(times2));
    }


    public static int majorityElement(int[] nums) {
        int moreTimes = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer value = map.get(nums[i]) + 1;
                map.put(nums[i], value);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() > moreTimes) {
                return pair.getKey();
            }
        }
        return -1;

    }
}
