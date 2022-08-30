package TreeTraverseExample;

import leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeveLOrderTraverseOrBFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }


    // prints in level order
    public void levelOrderTraversal(TreeNode startNode, List<Integer> list) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            list.add(tempNode.val);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }


}
