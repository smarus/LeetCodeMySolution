package cpbook4.ddd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoveCalculator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Double> doubles = new ArrayList<>();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().replaceAll(" ", "");
            line = line.replaceAll("[^a-zA-Z]", "");
            if (line.equals("") || line.isEmpty())
                break;
            String line1 = scanner.nextLine().replaceAll(" ", "");
            line1 = line1.replaceAll("[^a-zA-Z]", "");
            int number = convertAlphabet(line);
            int number1 = convertAlphabet(line1);
            number = getNumber(number);
            number1 = getNumber(number1);
            double result = ((number > number1 ? ((double) number1 / number) : (double) number / number1) * 100);

            doubles.add(result);
        }
        for (int i = 0; i < doubles.size(); i++) {
            String result = String.format("%.2f", doubles.get(i));
            System.out.println(result + " %");
        }


    }

    public static int convertAlphabet(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                sum += ((s.charAt(i) - 'A') + 1);
            } else
                sum += ((s.charAt(i) - 'a') + 1);
        }
        return sum;
    }

    public static int getNumber(int n) {
        while (n > 9) {
            n = getSumOfNumber(n);
        }
        return n;
    }

    public static int getSumOfNumber(int n) {
        if (n == 0)
            return 0;
        if (n < 10)
            return n;
        return getSumOfNumber(n / 10) + n % 10;

    }
}
