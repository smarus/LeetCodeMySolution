package easy.arrays;

public class Leet852 {
    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
