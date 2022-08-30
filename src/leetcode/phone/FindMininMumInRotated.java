package leetcode.phone;

public class FindMininMumInRotated {

    public static void main(String[] args) {

        //Find minimum
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};

        System.out.println(findMinimum(nums));
        int[] nums2 = new int[]{2, 4, 5, 6, 7, 0, 1};
        System.out.println(findMinimum(nums2));
        // mid = 6 - 0 / 2 + 0 = 3
        // mid == 7;
        // lo = mid + 1 = lo = 3 + 4;


        // 4,5,6,7,0,1,2
        // 2 4, 5, 6, 7 , 0 ,1
        // lo = 4
        // mid = 5
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
    }

    public static int findMinimum(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int boundaryIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {
                boundaryIndex = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return boundaryIndex;

    }
}
