package educative.dfs;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(findAllPathsSum(root, 23));

    }

    public static List<List<Integer>> findAllPathsSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        dfs(root, sum, currentPath, allPaths);
        return allPaths;


    }

    public static void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> total) {
        if (root == null)
            return;

        temp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            total.add(new ArrayList<>(temp));
        }

        dfs(root.left, sum - root.val, temp, total);
        dfs(root.right, sum - root.val, temp, total);
        temp.remove(temp.size() - 1);
    }


}
