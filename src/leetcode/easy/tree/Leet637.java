package leetcode.easy.tree;

import leetcode.easy.TreeNode;

import java.util.*;

public class Leet637 {
    public static void main(String[] args) {


    }


//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> result = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//
//        if(root == null) return result;
//        q.add(root);
//        while(!q.isEmpty()) {
//            int n = q.size();
//            double sum = 0.0;
//            for(int i = 0; i < n; i++) {
//                TreeNode node = q.poll();
//                sum += node.val;
//                if(node.left != null) q.offer(node.left);
//                if(node.right != null) q.offer(node.right);
//            }
//            result.add(sum / n);
//        }
//        return result;
//    }

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        preorder(root, 1, map);

        List<Double> doubleList = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            List<Integer> list = map.get(i);
            int count = 0;
            double sum = 0.0;
            for (Integer value : list) {
                sum += value;
                count++;
            }
            double average = sum / count;
            doubleList.add(average);
        }
        return doubleList;

    }

    public void preorder(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);

        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
}
