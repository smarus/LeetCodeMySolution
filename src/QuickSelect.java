public class QuickSelect {

    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 5, 1, 2, 7, 3, 9};
        int[] array2 = new int[]{9, 5, 5, 1, 2, 7, 3, 9};

        System.out.println(findKthLargest(array, 4));

        //start = 0 , end = 7    9, 5, 5, 1, 2, 7, 3, 9
        // partition 0 , 7
        // ---pivot  = 7
        // 9 == 9 start  = 1
        //
    }


    public static int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];


    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = end, temp;


        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            swap(nums, start, end);

        }
        System.out.println("start : " + start);
        System.out.println("end : " + end);
        System.out.println("pivot : " + pivot);

        swap(nums, end, pivot);
        return end;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//public class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int start = 0, end = nums.length - 1, index = nums.length - k;
//        while (start < end) {
//            int pivot = partion(nums, start, end);
//            if (pivot < index) start = pivot + 1;
//            else if (pivot > index) end = pivot - 1;
//            else return nums[pivot];
//        }
//        return nums[start];
//    }
//
//    private int partion(int[] nums, int start, int end) {
//        int pivot = start, temp;
//        while (start <= end) {
//            while (start <= end && nums[start] <= nums[pivot]) start++;
//            while (start <= end && nums[end] > nums[pivot]) end--;
//            if (start > end) break;
//            temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//        }
//        temp = nums[end];
//        nums[end] = nums[pivot];
//        nums[pivot] = temp;
//        return end;
//    }
//}