package educative.sliding_window;


//Given an array of positive numbers and a positive number ‘S’,
// find the length of the smallest
// contiguous subarray whose sum is greater
// than or equal to ‘S’. Return 0, if no such subarray exists.
public class SmallestSubarray {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 5, 2, 3, 2}; //2
        int[] array2 = new int[]{2, 1, 5, 2, 8};//1
        int[] array3 = new int[]{2, 1, 5, 2, 8};//3
        int s = 7;
        int s2 = 8;
        System.out.println(findMinSubArray(s, array));
        System.out.println(findMinSubArray(s, array2));
        System.out.println(findMinSubArray(s2, array3));
    }

    public static int findMinSubArray(int S, int[] array) {
        int sum = 0;
        int ws = 0;
        int min = Integer.MAX_VALUE;
        for (int wd = 0; wd < array.length; wd++) {
            sum += array[wd];
            while (sum >= S) {
                min = Math.min(min, wd - ws + 1);
                sum -= array[ws];
                ws++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
