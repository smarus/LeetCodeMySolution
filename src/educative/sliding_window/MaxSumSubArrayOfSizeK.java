package educative.sliding_window;


//Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 5, 1, 3, 2};
        //9
        System.out.println(findMaxSubSubArray(3, array));
        int[] array2 = new int[]{2, 3, 4, 1, 5};
        System.out.println(findMaxSubSubArray(2, array2));

    }

    public static int findMaxSubSubArray(int k, int[] arr) {
        int ws = 0;
        int max = 0;
        int sum = 0;
        for (int wd = 0; wd < arr.length; wd++) {
            sum += arr[wd];

            if (wd >= k - 1) {
                max = Math.max(max, sum);
                sum -= arr[ws];
                ws++;
            }
        }
        return max;
    }
}
