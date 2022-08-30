package cpbook4.ddd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RobotInst {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        int TC = Integer.parseInt(reader.readLine()); // number of test cases
        while (TC-- > 0) { // shortcut to repeat until 0
            String[] line = reader.readLine().trim().split(" ");
            try {
                double first = Double.parseDouble(line[0]);
                double second = Double.parseDouble(line[1]);
                double third = Double.parseDouble(line[2]);
                double fourth = Double.parseDouble(line[3]);

                if ((((first == 56.0 && second == 45.0 && third == 25.0)) || (first + second + third) <= 125.0) && fourth <= 7.00) {
                    result.add(1);
                } else {
                    result.add(0);
                }

            } catch (Exception e) {
                System.out.println();
            }
        }
        int sum = 0;
        for (Integer integer : result) {
            sum += integer;
            System.out.println(integer);
        }
        System.out.println(sum);
    }

}

