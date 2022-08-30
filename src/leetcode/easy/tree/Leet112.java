package leetcode.easy.tree;

import leetcode.easy.TreeNode;

public class Leet112 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return helper(root, targetSum, 0);
    }

    public boolean helper(TreeNode root, int targetSum, int prevSum) {
        if (root == null || targetSum == prevSum)
            return true;
        prevSum += root.val;
        if (root.left == null && root.right == null) {
            return targetSum == prevSum;
        }
        return helper(root.left, targetSum, prevSum) || helper(root.right, targetSum, prevSum);

    }
}
