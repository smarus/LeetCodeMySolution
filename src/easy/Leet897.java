package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Leet897 {

    TreeNode ans = null;
    TreeNode currentNode = null;

    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (ans == null) {
            ans = new TreeNode(root.val);
            currentNode = ans;
        } else {
            currentNode.right = new TreeNode(root.val);
            currentNode = currentNode.right;
        }
        dfs(root.right);

    }
}
