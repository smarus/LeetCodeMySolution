package TreeTraverseExample;


import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//In PreOrder traversal,each node is processed before either of its sub-trees.In simpler words,Visit each node before its children.
//        Steps for PreOrder traversal are:
//        Visit the node.
//        Traverse the left subtree in PreOrder.
//        Traverse the right subtree in PreOrder.
public class TraversePreOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);

        TraversePreOrder preOrder = new TraversePreOrder();
        List<Integer> values = preOrder.preorderTraversal(treeNode);

        System.out.println(values);
    }

    // Iterative traverse
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverseRecursive(root, list);
        return list;


    }

    // Iterative traverse
    public void traverseIterative(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            list.add(n.val);


            if (n.right != null) {
                stack.push(n.right);
            }

            if (n.left != null) {
                stack.push(n.left);
            }

        }
    }

    public void traverseRecursive(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        traverseRecursive(node.left, list);
        traverseRecursive(node.right, list);
    }
}
