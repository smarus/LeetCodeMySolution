package yandex_contest;

import java.io.*;

public class Solution2 {
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }


    private static String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    private static void writeLine(String IntToFile) throws IOException {
        bufferedWriter.write(IntToFile);
    }

    private static void run() throws IOException {
        String result = "";
        String[] arrayString = readLine().split(" ");
        if (arrayString[0].length() > 14 || arrayString[1].length() > 14) {
            result = sumBigNumber(arrayString[0], arrayString[1]);
        } else {
            long value = Long.parseLong(arrayString[0]) + Long.parseLong(arrayString[1]);
            result = String.valueOf(value);
        }
        writeLine(result);
    }

    static String sumBigNumber(String firstNumber, String secondNumber) {
        if (firstNumber.length() > secondNumber.length()) {
            String t = firstNumber;
            firstNumber = secondNumber;
            secondNumber = t;
        }
        StringBuilder str = new StringBuilder();
        int n1 = firstNumber.length(), n2 = secondNumber.length();
        firstNumber = new StringBuilder(firstNumber).reverse().toString();
        secondNumber = new StringBuilder(secondNumber).reverse().toString();
        int carry = 0;
        //Школьная математика
        for (int i = 0; i < n1; i++) {
            int sum = ((firstNumber.charAt(i) - '0') +
                    (secondNumber.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));

            carry = sum / 10;
        }

        for (int i = n1; i < n2; i++) {
            int sum = ((int) (secondNumber.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        if (carry > 0)
            str.append((char) (carry + '0'));

        str = new StringBuilder(new StringBuilder(str.toString()).reverse().toString());
        return str.toString();
    }


}
