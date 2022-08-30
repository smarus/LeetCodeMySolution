package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubS {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        System.out.println(findPermute(nums));
    }


    public static List<List<Integer>> findPermute(int[] nums) {
        List<List<Integer>> permute = new ArrayList<>();
        permute(0, nums, new ArrayList<>(), permute);
        return permute;
    }

    public static void permute(int index, int[] nums, List<Integer> temp, List<List<Integer>> total) {
        if (index == nums.length) {
            total.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            permute(index + 1, nums, temp, total);
            temp.remove(temp.size() - 1);
        }
    }
}
