package easy.tree;

import easy.TreeNode;

import java.util.*;

public class Leet107 {
    public static void main(String[] args) {

    }

//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        Stack<Integer> integers = new Stack<>();
//        queue.add(root);
//        TreeNode current;
//
//        while (!queue.isEmpty()){
//            current = queue.poll();
//
//            if (current.left != null)
//                queue.add(current.left);
//
//            if (current.right != null){
//                queue.add(current.right);
//            }
//
//        }
//
//    }
//    void printLevelOrder(TreeNode root)
//    {
//        int h = height(root);
//        int i;
//        for (i=1; i<=h; i++)
//            printGivenLevel(root, i);
//    }
//
//    int height(TreeNode root)
//    {
//        if (root == null)
//            return 0;
//        else
//        {
//            /* compute  height of each subtree */
//            int lheight = height(root.left);
//            int rheight = height(root.right);
//
//            /* use the larger one */
//            if (lheight > rheight)
//                return(lheight+1);
//            else return(rheight+1);
//        }
//    }
//
//    void printGivenLevel (TreeNode root ,int level)
//    {
//        if (root == null)
//            return;
//        if (level == 1)
//            System.out.print(root.val + " ");
//        else if (level > 1)
//        {
//            printGivenLevel(root.left, level-1);
//            printGivenLevel(root.right, level-1);
//        }
//    }

}
