package TreeTraverseExample;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//
//Create an empty stack s and set currentNode =root.
//        while currentNode is not NULL Do following
//        Push currentNode ‘s right child and then currentNode to stack.
//        Set currentNode =currentNode .left
//        Pop a node from stack and set it as root and set it to currentNode
//        If the popped node has a right child and the right child is at top of stack, then remove the right child from stack, push the current node back and set currentNode as currentNode ‘s right child.
//        Else print currentNode ‘s data and set currentNode as NULL.
//        Repeat steps 2 and 3 while stack is not empty.


public class TraversePostOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);

        TraversePreOrder preOrder = new TraversePreOrder();
        List<Integer> values = preOrder.preorderTraversal(treeNode);

        System.out.println(values);
    }

    // Iterative traverse
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverseRecursive(root, list);
        return list;


    }

    // Iterative traverse
    public void traverseIterative(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            if (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                stack.push(current);
                current = current.left;
                continue;
            }
            if (stack.isEmpty()) {
                return;
            }
            current = stack.pop();
            if (current.right != null && !stack.isEmpty() && current.right == stack.peek()) {
                stack.pop();
                stack.push(current);
                current = current.right;
            } else {
                list.add(current.val);
                current = null;
            }
        }
    }

    public void traverseRecursive(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        traverseRecursive(node.left, list);
        traverseRecursive(node.right, list);
        list.add(node.val);
    }
}
