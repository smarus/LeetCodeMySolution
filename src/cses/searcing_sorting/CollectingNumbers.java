package cses.searcing_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CollectingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] input = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int i = 0;
        //   int [] copy = Arrays.copyOf(input, input.length);

        int swap = 1;
//        while(i < input.length){
//            int j = input[i] - 1;
//            if (input[i] != input[j]){
//                swap++;
//                swap(input, i, j);
//            }else{
//                i++;
//            }
//        }
        for (int j = 1; j < input.length; j++) {
            if (input[j] < input[j - 1])
                swap++;
        }
        System.out.println(swap);
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


}
