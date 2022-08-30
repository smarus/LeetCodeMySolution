package algorithms_coursera.graph;


import java.util.ArrayList;
import java.util.Scanner;

public class Tain {
    boolean[] used;
    boolean[] ans;
    int[] timeIn;
    int[] timeOut;
    int time = 0;
    int count = 0;
    ArrayList<Integer>[] adjanceList;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Tain main = new Tain();
        main.used = new boolean[n];
        main.timeIn = new int[n];
        main.timeOut = new int[n];
        main.adjanceList = new ArrayList[n];
        main.ans = new boolean[n];
        for (int i = 0; i < n; i++) {
            main.adjanceList[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            main.adjanceList[u - 1].add(v - 1);
            main.adjanceList[v - 1].add(u - 1);
        }

        for (int i = 0; i < n; i++) {
            if (!main.used[i]) {
                main.dfs(i);
            }
        }

        System.out.println(main.count);


    }

    public void dfs(int v) {
        used[v] = true;
        timeIn[v] = time++;
        for (int i : adjanceList[v]) {
            if (timeIn[v] < timeIn[i] && timeOut[i] > timeOut[v]) {
                count++;
            }
            if (!used[i])
                dfs(i);
        }
        timeOut[v] = time++;

    }
}
