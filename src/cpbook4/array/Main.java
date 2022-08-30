package cpbook4.array;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedInputStream input = new BufferedInputStream(System.in);
        BufferedOutputStream output = new BufferedOutputStream(System.out);
        int TC = Integer.parseInt(input.readLine()); // number of test cases
        int testCase = 0;
        while (TC-- > 0) { // shortcut to repeat until 0
            System.out.println(TC);
            int[] solvedQuestions = new int[10001];
            String[] first = input.readLine().split(" ");
            int[] firstArray = new int[Integer.parseInt(first[0])];
            for (int i = 0; i < firstArray.length; i++) {
                firstArray[i] = Integer.parseInt(first[i + 1]);
                solvedQuestions[firstArray[i]]++;
            }

            String[] second = input.readLine().split(" ");
            int[] secondArray = new int[Integer.parseInt(second[0])];
            for (int i = 0; i < secondArray.length; i++) {
                secondArray[i] = Integer.parseInt(second[i + 1]);
                solvedQuestions[secondArray[i]]++;
            }

            String[] third = input.readLine().split(" ");
            int[] thirdArray = new int[Integer.parseInt(third[0])];
            for (int i = 0; i < thirdArray.length; i++) {
                thirdArray[i] = Integer.parseInt(third[i + 1]);
                solvedQuestions[thirdArray[i]]++;
            }
            int firstNumber = findDifference(firstArray, solvedQuestions);
            int secondNumber = findDifference(secondArray, solvedQuestions);
            int thirdNumber = findDifference(thirdArray, solvedQuestions);

            testCase++;
            System.out.println("Case #" + testCase + ":");
            if (firstNumber > secondNumber && firstNumber > thirdNumber) {
                System.out.println(buildString(1, firstArray));
            } else if (secondNumber > firstNumber && secondNumber > thirdNumber)
                System.out.println(buildString(2, secondArray));
            else {
                System.out.println(buildString(3, thirdArray));
            }

        }
    }

    public static int findDifference(int[] first, int[] second) {
        int count = 0;
        for (int j : first) {
            if (second[j] == 1)
                count++;
        }

        return count;
    }

    public static String buildString(int number, int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(number);
        stringBuilder.append(" ");
        stringBuilder.append(array.length);
        stringBuilder.append(" ");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
