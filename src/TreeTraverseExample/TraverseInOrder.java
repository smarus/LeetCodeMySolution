package TreeTraverseExample;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//In InOrder traversal,each node is processed between subtrees.In simpler words,Visit left subtree, node and then right subtree.
//        Steps for InOrder traversal are:
//        Traverse the left subtree in InOrder.
//        Visit the node.
//        Traverse the right subtree in InOrder.
public class TraverseInOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        TraverseInOrder inOrder = new TraverseInOrder();
        List<Integer> values = inOrder.inorderTraversal(treeNode);

        System.out.println(values);
    }

    // Iterative traverse
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverseIterative(root, list);
        return list;


    }

    // Iterative traverse
    public void traverseIterative(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode n = stack.pop();
                list.add(n.val);
                currentNode = n.right;
            }

        }
    }

    public void traverseRecursive(TreeNode node, List<Integer> list) {
        if (node != null) {
            traverseRecursive(node.left, list);
            list.add(node.val);
            traverseRecursive(node.right, list);
        }
    }
}
