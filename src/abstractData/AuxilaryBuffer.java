package abstractData;

import java.util.Arrays;

public class AuxilaryBuffer {

    public static void main(String[] args) {

        int[] buffer = new int[3];
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        printCombos(array, buffer, 0, 0);
    }


    public static void printCombos(int[] array, int[] buffer, int startIndex, int bufferIndex) {

        if (bufferIndex == buffer.length) {
            System.out.println(Arrays.toString(buffer));
            return;
        }

        if (startIndex == array.length) {
            return;
        }

        for (int i = startIndex; i < array.length; i++) {
            buffer[bufferIndex] = array[i];
            printCombos(array, buffer, startIndex + 1, bufferIndex + 1);
        }
    }


}
