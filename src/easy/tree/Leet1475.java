package easy.tree;

import easy.TreeNode;

public class Leet1475 {


    public static void main(String[] args) {
        //[2,2,2,5,2]
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;

        System.out.println(isUnivalTree(treeNode));

    }

    public static boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return isTreeEqual(root, val);
    }

    public static boolean isTreeEqual(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val)
            return false;
        else {
            int value = node.val;
            return isTreeEqual(node.left, value) && isTreeEqual(node.right, value);
        }

    }
}
