package repeat.contest.route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Table {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        while (TC-- > 0) {
            reader.readLine();
            int[] nm = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<int[]> matrix = new ArrayList<>();
            int index = 0;
            while (index < nm[0]) {
                int[] array = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                matrix.add(array);
                index++;
            }

            int c = Integer.parseInt(reader.readLine());
            int[] cols = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int col : cols) {
                Comparator<int[]> comparator = Comparator.comparingInt(o -> o[col - 1]);
                matrix.sort(comparator);
            }
            printArray(matrix);

        }
    }


    public static void printArray(List<int[]> matrix) {
        for (int[] array : matrix) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i != array.length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
