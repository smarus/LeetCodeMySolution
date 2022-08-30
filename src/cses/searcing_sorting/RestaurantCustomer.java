package cses.searcing_sorting;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class RestaurantCustomer {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] input = Stream.of(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(new int[]{input[0], 1});
            list.add(new int[]{input[1], -1});
        }
        Collections.sort(list, (l1, l2) -> Integer.compare(l1[0], l2[0]));
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i)[1];
            res = Math.max(sum, res);
        }

        System.out.println(res);
    }


//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    int [][] array = new int[n][2];
//        for(int i = 0;i<n; i++){
//        for (int j = 0; j < 2; j++) {
//            array[i][j] = scanner.nextInt();
//        }
//    }
//        Arrays.sort(array, (o1, o2) -> Integer.compare(o1[0], o2[0]));
//
//    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b)-> Integer.compare(a[1], b[1]));
//    int max = 0;
//        for(int [] arr: array){
//        while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= arr[0])
//            priorityQueue.poll();
//
//        priorityQueue.offer(arr);
//        max = Math.max(max, priorityQueue.size());
//    }
//
//        System.out.println(max);

}
