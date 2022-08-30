package cpbook4.ds.array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String line = null;
        List<Boolean> booleans = new ArrayList<>();
        while ((line = reader.readLine()) != null && !line.isEmpty()) { // keep looping
            String[] token = line.split(" ");
            int[] numberSequence = new int[token.length];
            for (int i = 0; i < token.length; i++) {
                numberSequence[i] = Integer.parseInt(token[i]);
            }
            System.out.println(Arrays.toString(numberSequence));
            int n = numberSequence.length;
            if (isJolly(numberSequence, n))
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");
        }


    }

    static boolean isJolly(int a[], int n) {
        if (a.length < 3)
            return true;
        // Boolean vector to diffSet set of differences.
        // The vector is initialized as false.
        boolean[] diffSet = new boolean[n];

        // Traverse all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find absolute difference
            // between current two
            int d = Math.abs(a[i] - a[i + 1]);

            // If difference is out of range or repeated,
            // return false.
            if (d == 0 || d > n - 1 ||
                    diffSet[d])
                return false;

            // Set presence of d in set.
            diffSet[d] = true;
        }
        return true;
    }

}
//    public static void main(String[] args) throws IOException {
//        List<String> answers = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//         while ((line = reader.readLine()) != null && !line.isEmpty()) { // keep looping
//           String[] token = line.split(" ");
//           int[] difference = new int[token.length - 1];
//           int k = 0;
//           int prev = Integer.MIN_VALUE;
//           for (int i = 1; i < token.length; ++i) {
//               if (prev == Integer.MIN_VALUE) {
//                   prev = Math.abs(Integer.parseInt(token[i - 1]) - Integer.parseInt(token[i]));
//               } else {
//                   prev = Math.abs(Integer.parseInt(token[i]) - prev);
//               }
//
//               difference[k] = prev;
//               k++;
//             }
//             System.out.println(Arrays.toString(difference));
//             Arrays.sort(difference);
//
//             boolean isJolly = true;
//             System.out.println(Arrays.toString(difference));
//             for (int i = 0; i < difference.length - 1; i++) {
//                 if (difference[i] == difference[i+1])
//                     continue;
//                 if ((i+1) != difference[i])
//                     isJolly = false;
//             }
//
//             if (isJolly){
//                 answers.add("Jolly");
//             }else{
//                 answers.add("Not jolly");
//             }
//         }
//
//        System.out.println(answers);
//    }

