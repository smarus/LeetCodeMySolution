package leetcode.medium.tree;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet1022 {
    //best
//        public int sumRootToLeaf(TreeNode root) {
//            if(root == null) {
//                return 0;
//            }
//            return helper(root, 0);
//        }
//
//        private int helper(TreeNode root, int prevSum) {
//            if(root==null) {
//                return 0;
//            }
//            prevSum = 2*prevSum + root.val;
//
//            if(root.left == null && root.right == null) {
//                return prevSum; //leaf node return the sum until root
//            }
//            return helper(root.left, prevSum) + helper(root.right, prevSum);

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        int len = 0;
        traverse(root, list, len);
        return sum;
    }

    public void traverse(TreeNode root, List<Integer> list, int len) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        len++;
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(list.get(i));

            }
            sum += Integer.parseInt(sb.toString(), 2);
        } else {
            traverse(root.left, list, len);
            traverse(root.right, list, len);
        }

        list.remove(list.size() - 1);

    }
}

