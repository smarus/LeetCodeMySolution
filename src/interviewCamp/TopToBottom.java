package interviewCamp;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TopToBottom {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftSub = new TreeNode(2);
        TreeNode leftSubSub = new TreeNode(5);

        TreeNode rightSub = new TreeNode(3);
        TreeNode rightLeftSub = new TreeNode(4);
        TreeNode rightRightSub = new TreeNode(6);
        rightSub.left = rightLeftSub;
        rightSub.right = rightRightSub;
        leftSub.left = leftSubSub;
        root.left = leftSub;
        root.right = rightSub;

        System.out.println(deepestLeavesSum(root));

    }

    public static List<List<Integer>> getAllPath(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, new ArrayList<>(), result);
        return result;


    }

    public static void helper(TreeNode root, List<Integer> currentList, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        currentList.add(root.val);
        if (root.left == null && root.right == null)
            result.add(new ArrayList<>(currentList));
        helper(root.left, currentList, result);
        helper(root.right, currentList, result);
        currentList.remove(currentList.size() - 1);

    }

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        int prevSum = -1;
        int maxSum = -1;
        int value = root.val;

        maxLength(root.left, prevSum, maxSum, value);
        sum += value;
        maxLength(root.right, prevSum, maxSum, value);
        sum += value;
        return sum;
    }

    public static void maxLength(TreeNode root, int prevSum, int maxSum, int value) {
        if (root == null)
            return;

        int currentSum = prevSum + 1;
        if (currentSum > maxSum) {
            maxSum = currentSum;
            value = root.val;
        }
        maxLength(root.left, currentSum, maxSum, value);
        maxLength(root.right, currentSum, maxSum, value);

    }
}
