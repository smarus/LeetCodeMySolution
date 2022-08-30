package educative.binary_search;

public class MinimumRotedSortedArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{30, 40, 50, 10, 20};
        int[] array2 = new int[]{3, 5, 7, 11, 13, 17, 19, 2};

        int[] firstOccurence = new int[]{1, 3, 3, 3, 3, 6, 10, 10, 10, 100};
        boolean[] bools = new boolean[]{false, false, true, true, true};
        System.out.println(findFirstOccurence(firstOccurence, 3));
    }


    public static int findFirstOccurence(int[] array, int target) {

        int lo = 0;
        int hi = array.length - 1;
        int firstIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (array[mid] == target) {
                firstIndex = mid;
                hi = mid - 1;
            } else if (target > array[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return firstIndex;
    }

    public static int findFirst(boolean[] booleans) {

        int lo = 0;
        int hi = booleans.length - 1;
        int rotatedIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (booleans[mid]) {
                hi = mid - 1;
                rotatedIndex = mid;
            } else {
                lo = mid + 1;
            }
        }
        return rotatedIndex;

    }


    public static int findMinRotated(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[hi]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
