package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Route {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        while (count-- != 0) {
            String[] numbers = reader.readLine().split(" ");
            System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
        }
    }
}
