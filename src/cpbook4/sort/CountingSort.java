package cpbook4.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 2, 2, 3, 3};
        int[] output = new int[array.length + 1];
        int l = 2;
        int r = 5;
        int k = r - l + 1;
        int[] freq = new int[k];
        for (int i = 0; i < array.length; i++) {
            freq[array[i] - l]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i - 1] + freq[i];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            output[freq[array[j] - l] - 1] = array[j];
            freq[array[j] - l]--;
        }

        System.out.println(Arrays.toString(output));

    }
}
