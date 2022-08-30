package leetcode.easy.tree;

import leetcode.easy.TreeNode;

public class Leet617 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode leftNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(2);
        leftNode.left = new TreeNode(5);
        node.left = leftNode;
        node.right = rightNode;
        ////
        TreeNode node2 = new TreeNode(2);
        TreeNode leftNode2 = new TreeNode(1);
        TreeNode rightNode2 = new TreeNode(3);
        leftNode2.right = new TreeNode(4);
        rightNode2.right = new TreeNode(7);
        node2.left = leftNode2;
        node2.right = rightNode2;


        TreeNode t = mergeTrees(node, node2);
        print(t);


    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
//         if (t1 != null && t2 != null){
//             mergeTrees(t1.left, t2.left);
//             mergeTrees(t1.right, t2.right);
//             t1.val = t1.val + t2.val;
//
//         } else if (t1 == null && t2 != null){
//             t1 = new TreeNode(t2.val);
//             t1.left = t2.left;
//             t1.right = t2.right;
//             }
        return t1;
    }


    static void print(TreeNode t) {
        if (t != null) {
            System.out.println(t.val);
            print(t.left);
            print(t.right);
        }
    }
}
