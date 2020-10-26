package easy.bit_operation;


//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//        You may assume that the array is non-empty and the majority element always exist in the array.


//Input: [3,2,3]
//        Output: 3

//
//Input: [2,2,1,1,1,2,2]
//        Output: 2

import java.util.HashMap;
import java.util.Map;

public class Leet169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
                key = pair.getKey();
            }
        }
        return key;
    }
}

//    public class Solution {
//        public int majorityElement(int[] num) {
//
//            int major=num[0], count = 1;
//            for(int i=1; i<num.length;i++){
//                if(count==0){
//                    count++;
//                    major=num[i];
//                }else if(major==num[i]){
//                    count++;
//                }else count--;
//
//            }
//            return major;
//        }

