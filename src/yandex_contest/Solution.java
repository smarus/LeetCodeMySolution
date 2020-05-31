package yandex_contest;

import java.io.*;

public class Solution {
    private static final String FILE_INPUT = "/Users/ruslakur/IdeaProjects/LeetCodeMySolution/src/yandex_contest/input.txt";
    private static final String FILE_OUTPUT = "/Users/ruslakur/IdeaProjects/LeetCodeMySolution/src/yandex_contest/output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }


    private static void writeLine(int IntToFile) throws IOException {
        bufferedWriter.write(String.valueOf(IntToFile));
    }

    private static void run() throws IOException {
        int result = 0;
        String input = bufferedReader.readLine();
        int target = Integer.parseInt(input);
        String string = bufferedReader.readLine().trim();
        input = null;
        int count = 1;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                count++;
            }
        }
        int[] array = new int[count];
        count = 0;
        int beginNumber = 0;
        int endNumber;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                endNumber = i;
                array[count] = Integer.parseInt(string.substring(beginNumber, endNumber));
                count++;
                beginNumber = endNumber + 1;
            } else if (i == string.length() - 1) {
                array[count] = Integer.parseInt(string.substring(beginNumber, string.length()));
            }
        }

        sortArray(array);

        int low = 0;
        int high = array.length - 1;
        while (high > low) {
            if (array[low] + array[high] > target) {
                array[high] = 0;
                high--;
            } else if (array[low] + array[high] < target) {
                array[low] = 0;
                low++;
            } else {
                result = 1;
                break;
            }

        }
        array = null;
        writeLine(result);
//         }
        //       HashSet<Integer> set = new HashSet<>();
//         for (int i = 0; i < arrayString.length ; i++) {
//             int value = Integer.parseInt(arrayString[i]);
//            int t = target - Integer.parseInt(arrayString[i]);
//            if (set.contains(t)){
//                result = 1;
//                break;
//            }
//            set.add(value);
//         }
    }


    public static void sortArray(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }


}
