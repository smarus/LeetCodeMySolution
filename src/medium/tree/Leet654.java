package medium.tree;

import easy.TreeNode;

public class Leet654 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree(nums);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length, nums);

    }

    public static TreeNode construct(int low, int high, int[] nums) {
        if (high - low > 0) {
            int index = low;
            for (int i = low; i < high; i++) {
                if (nums[i] > nums[index]) {
                    index = i;
                }
            }

            return new
                    TreeNode(nums[index],
                    construct(low, index, nums),
                    construct(index + 1, high, nums));
        }

        return null;
    }
}
