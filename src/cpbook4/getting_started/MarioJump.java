package cpbook4.getting_started;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MarioJump {
    public static void main(String[] args) throws IOException {
        List<String> string = new ArrayList<>();
        //Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(""))
                break;
            String[] numbers = line.split(" ");
            int max = Integer.parseInt(numbers[0]);
            for (int i = 0; i < numbers.length; i++) {
                if (Integer.parseInt(numbers[i]) > max) {
                    max = Integer.parseInt(numbers[i]);
                }
            }
            string.add(String.valueOf(max));
        }
        for (int i = 0; i < string.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + string.get(i));
        }
    }
}
