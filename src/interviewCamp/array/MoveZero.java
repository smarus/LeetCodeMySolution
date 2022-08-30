package interviewCamp.array;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 0, 3, 1, 0};

        int pointer = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                swap(array, i, pointer);
                pointer--;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
