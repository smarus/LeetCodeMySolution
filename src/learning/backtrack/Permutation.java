package learning.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        List<List<Integer>> permutation = new ArrayList<>();
        int[] num = new int[]{1, 2, 3};
//     dfs(num, 0, new ArrayList<>(), permutation);
//        System.out.println(permutation);

        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int n = nums.length;
        // initialize prefix sum
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];

        System.out.println(Arrays.toString(sum));

    }

    // preSum[j+1] - preSum[i]

    /*
   function dfs(node, state):
    if state is a solution:
        report(state) # e.g. add state to final result list
        return

    for child in children:
        if child is a part of a potential solution:
            state.add(child) # make move
            dfs(child, state)
            state.remove(child) # backtrack
    */
    public static void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> permutation) {
        if (index == nums.length) {
            permutation.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (temp.contains(num)) continue;
            temp.add(num);
            dfs(nums, index + 1, temp, permutation);
            temp.remove(temp.size() - 1);
        }

    }
}
