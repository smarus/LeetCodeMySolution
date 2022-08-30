package cpbook4.ddd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Score {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        int TC = Integer.parseInt(reader.readLine()); // number of test cases
        while (TC-- > 0) { // shortcut to repeat until 0
            String line = reader.readLine();
            int sum = 0;
            int num = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'X') {
                    num = 0;
                } else {
                    num += 1;
                }
                sum += num;
            }
            result.add(sum);
        }
        System.out.println();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
