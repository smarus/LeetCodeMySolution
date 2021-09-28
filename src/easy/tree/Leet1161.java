package easy.tree;

import easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet1161 {

    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize ; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);

                if (sum > max){
                    max = sum;
                    maxLevel = level;
                }


            }

            level++;
        }
        return maxLevel;
    }
}
