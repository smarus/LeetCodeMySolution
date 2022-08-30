package educative.subset;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3};
        System.out.println(breathFirstSearch(array));
    }

    public static List<List<Integer>> findSubSet(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();

        subsets(nums, 0, new ArrayList<>(), subset);

        return subset;
    }

    public static void subsets(int[] nums, int index, List<Integer> templist, List<List<Integer>> subset) {
        subset.add(new ArrayList<>(templist));
        if (index == nums.length)
            return;
        templist.add(nums[index]);
        subsets(nums, index + 1, templist, subset);
        templist.remove(templist.size() - 1);
    }

    public static List<List<Integer>> breathFirstSearch(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = subset.size();
            for (int j = 0; j < n; j++) {
                List<Integer> oldInteger = new ArrayList<>(subset.get(j));
                oldInteger.add(nums[i]);
                subset.add(oldInteger);
            }
        }
        return subset;
    }
}
