package abstractData;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchInRotatedArray(array, 0));

    }

    public static int searchInRotatedArray(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target)
                return mid;

            if (array[mid] >= array[start]) {
                if (target > array[start] && target < array[mid]) {
                    end = mid + 1;
                } else
                    start = mid - 1;
            } else {
                if (target > array[mid] && target < array[end]) {
                    start = mid + 1;
                } else
                    end = mid - 1;
            }
        }

        return -1;
    }
}
