package easy.tree;

import easy.TreeNode;

public class Leet872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {


        if (root1 == null || root2 == null)
            return false;

        if (root1.left == null && root1.right == null &&
                root2.left == null && root2.right == null) {
            if (root1.val != root2.val)
                return false;
        }

        if (root1.left != null && root2.left != null) {
            leafSimilar(root1.left, root2.left);
        }
        if (root1.right != null && root2.right != null) {
            leafSimilar(root1.right, root2.right);
        }

        return true;

    }
}
