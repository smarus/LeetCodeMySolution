package leetcode.medium.tree;

import leetcode.easy.TreeNode;

public class Leet129 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));

    }

    public static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, 0);
    }

    public static int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum += root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        int leftSum = 0;
        int rightSum = 0;

        if (root.left != null)
            leftSum = helper(root.left, sum * 10);

        if (root.right != null)
            rightSum = helper(root.right, sum * 10);

        return leftSum + rightSum;
    }

}
