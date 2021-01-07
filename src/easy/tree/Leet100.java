package easy.tree;

import easy.TreeNode;

import java.util.Stack;

public class Leet100 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        Stack<TreeNode> p1 = new Stack<>();
        Stack<TreeNode> q1 = new Stack<>();
        p1.push(p);
        q1.push(q);
        while (!p1.isEmpty() && !q1.isEmpty()) {
            TreeNode current1 = p1.pop();
            TreeNode current2 = q1.pop();
            if (current1 == null || current2 == null)
                return false;
            if (current1.val != current2.val)
                return false;

            if (current1.left != null && current2.left != null) {
                p1.push(current1.left);
                q1.push(current2.left);
            } else if (current1.left == null && current2.left != null)
                return false;
            else if (current1.left != null && current2.left == null)
                return false;
            if (current1.right != null && current2.right != null) {
                p1.push(current1.right);
                q1.push(current2.right);
            } else if (current1.right == null && current2.right != null)
                return false;
            else if (current1.right != null && current2.right == null)
                return false;

        }
        return true;
    }
}
