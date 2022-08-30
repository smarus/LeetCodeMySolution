package educative.dfs;

import leetcode.easy.TreeNode;

public class SumOfPathNumber {
    static int totalSum = 0;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(5);

            /*  1
              0   1
             1   6   5*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println(findSumOfPathNumbers(root));

    }

    public static int findSumOfPathNumbers(TreeNode root) {

        findNumber(root, 0);
        return totalSum;
    }


    public static int findNumbers(TreeNode root, int currentSum) {
        if (root == null)
            return 0;

        currentSum += root.val;

        if (root.left == null && root.right == null)
            return currentSum;

        return findNumbers(root.left, currentSum * 10) + findNumbers(root.right, currentSum * 10);

    }

    public static void findNumber(TreeNode root, int currentSum) {
        if (root == null)
            return;

        currentSum += root.val;
        if (root.left == null && root.right == null) {
            totalSum += currentSum;
        }

        findNumber(root.left, currentSum * 10);
        findNumber(root.right, currentSum * 10);
    }
}