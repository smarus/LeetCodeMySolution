package leetcode.easy.binara_search;

public class Leet35 {

    //   Given a sorted array and a target value, return the
    // index if the target is found. If not, return the index where it would be if it were inserted in order.
    // You may assume no duplicates in the array.
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};
        int[] array2 = new int[]{1, 3, 5, 6};
        int[] array3 = new int[]{1, 3};
        System.out.println(searchInsert(array, 7));
        System.out.println(searchInsert(array2, 0));
        System.out.println(searchInsert(array3, 2));
    }

    public static int searchInsert(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;
        int nextValue = 0;
        int mid = lo + (hi - lo) / 2;

        while (lo <= hi) {

            if (mid == 0 && target < nums[mid]) return mid;
            if (mid == nums.length && target > nums[mid]) return mid;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;

            }
            mid = lo + (hi - lo) / 2;

        }


        return mid;

    }

}
