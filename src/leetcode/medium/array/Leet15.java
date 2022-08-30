package leetcode.medium.array;

import java.util.*;

public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet();
        if (nums.length <= 1)
            return new ArrayList<>(list);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {

                    List<Integer> number = Arrays.asList(nums[i], nums[l], nums[r]);
                    list.add(number);
                }
                r--;
                l++;
            }
        }

        return new ArrayList<>(list);
    }
}
