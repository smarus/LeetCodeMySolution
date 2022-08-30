package educative.dfs;

import leetcode.easy.TreeNode;

public class PathGivenSequence {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println(findPath(root, new int[]{1, 1, 6}));
        System.out.println(findPath(root, new int[]{1, 9, 9}));

    }

    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPath(root, sequence, 0);
    }

    public static boolean findPath(TreeNode root, int[] sequence, int i) {
        if (root == null || i > sequence.length)
            return false;

        if (sequence[i] != root.val)
            return false;

        if (root.left == null && root.right == null && i == sequence.length - 1) {
            return true;
        }

        return findPath(root.left, sequence, i + 1) || findPath(root.right, sequence, i + 1);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[len] = nums1[i];
                i--;
            } else {
                nums1[len] = nums2[j];
                j--;
            }
            len--;

        }
        while (j >= 0) {
            nums1[len--] = nums2[j--];
        }
    }


}
