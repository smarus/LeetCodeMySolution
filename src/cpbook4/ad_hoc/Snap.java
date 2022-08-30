package cpbook4.ad_hoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = reader.readLine();
            if (line.equals("0 0 0 0 0"))
                break;
            int[] card = new int[53];
            String[] values = line.split(" ");
            int A = Integer.parseInt(values[0]);
            int B = Integer.parseInt(values[1]);
            int C = Integer.parseInt(values[2]);
            int X = Integer.parseInt(values[3]);
            int Y = Integer.parseInt(values[4]);
            card[A] = 1;
            card[B] = 1;
            card[C] = 1;
            card[X] = 1;
            card[Y] = 1;

        }
    }

    public void checkValues(int A, int B, int C, int X, int Y, int Z) {

    }
}
