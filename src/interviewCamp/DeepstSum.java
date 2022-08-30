package interviewCamp;

import leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepstSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftSubLef = new TreeNode(4);
        TreeNode leftSubRig = new TreeNode(5);
        TreeNode leftSubSubLeft = new TreeNode(7);
        leftSubLef.left = leftSubSubLeft;
        left.left = leftSubLef;
        left.right = leftSubRig;
        treeNode.left = left;

        TreeNode right = new TreeNode(3);
        TreeNode Subright = new TreeNode(6);
        TreeNode SubSubright = new TreeNode(8);
        Subright.right = SubSubright;
        right.right = Subright;
        treeNode.right = right;

        System.out.println(deepestLeavesSum(treeNode));
    }

    public static int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null)
            return sum;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            int localSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                localSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            sum = localSum;
        }
        return sum;
    }
}
