package educative.sliding_window;

public class ReplacingOnes {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(findLength(array, 2));
    }

    public static int findLength(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }

        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        int[] freqArray = new int[2];

        for (int end = 0; end < arr.length; end++) {
            int rightNumber = arr[end];
            freqArray[rightNumber]++;
            maxCount = Math.max(maxCount, freqArray[rightNumber]);

            if (end - start + 1 - maxCount > k) {
                int leftNumber = arr[start];
                freqArray[leftNumber]--;
                start++;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }

        return maxLength;
    }
}
