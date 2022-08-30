package educative.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        //System.out.println(findPermutationsBfs(array));
        System.out.println(findPermutationsDfs(array));
    }

    public static List<List<Integer>> findPermutationsBfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutation = new LinkedList<>();
        permutation.add(new ArrayList<>());
        for (int num : nums) {
            int n = permutation.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutation.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);

                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutation.offer(newPermutation);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> findPermutationsDfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateSubset(nums, 0, current, result);
        return result;
    }

    public static void generateSubset(int[] nums, int index, List<Integer> current, List<List<Integer>> allPath) {
        if (nums.length == index) {
            allPath.add(current);
        } else {
            for (int i = 0; i <= current.size(); i++) {
                List<Integer> newPermutaton = new ArrayList<>(current);
                newPermutaton.add(i, nums[index]);
                generateSubset(nums, index + 1, newPermutaton, allPath);
            }
        }
    }
}
