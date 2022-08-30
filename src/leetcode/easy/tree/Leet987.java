package leetcode.easy.tree;

import leetcode.easy.TreeNode;

import java.util.*;

public class Leet987 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        right.left = rightLeft;
        right.right = rightRight;
        root.right = right;

        System.out.println(verticalTraversal(root));

    }


    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        TreeColLevel treeColLevel = new TreeColLevel(0, 0, root);

        Deque<TreeColLevel> queue = new ArrayDeque<>();
        queue.offer(treeColLevel);

        List<List<Integer>> collumLevelOrder = new ArrayList<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int minimumCol = 0;
        int maximumCol = 0;

        while (!queue.isEmpty()) {
            TreeColLevel tree = queue.poll();
            TreeNode node = tree.node;
            System.out.println(tree.col);
            if (!colMap.containsKey(tree.col)) {
                colMap.put(tree.col, new ArrayList<>());
            }

            colMap.get(tree.col).add(node.val);

            if (node.left != null) {
                queue.offer(new TreeColLevel(tree.col - 1, tree.level + 1, node.left));
                minimumCol = Math.min(minimumCol, tree.col - 1);
            }

            if (node.right != null) {
                queue.offer(new TreeColLevel(tree.col + 1, tree.level + 1, node.right));
                maximumCol = Math.max(maximumCol, tree.col + 1);
            }
        }
        for (int i = minimumCol; i <= maximumCol; i++) {
            List<Integer> values = colMap.get(i);
            if (values.size() > 1) {
                Collections.sort(values);
            }

            collumLevelOrder.add(values);
        }


        return collumLevelOrder;
    }


    static class TreeColLevel {
        int col;
        int level;
        TreeNode node;

        public TreeColLevel(int col, int level, TreeNode node) {
            this.col = col;
            this.node = node;
            this.level = level;

        }
    }
}
