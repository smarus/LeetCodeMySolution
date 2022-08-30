package TreeTraverseExample;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    boolean[] used;
    int[] cc;
    int count;
    ArrayList<Integer>[] adjanceList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Main main = new Main();
        main.used = new boolean[n];
        main.cc = new int[n];
        main.adjanceList = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            main.adjanceList[v] = new ArrayList<>();
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
                main.count++;
            }
        }

        System.out.println(main.count);
        for (int i = 0; i < main.cc.length; i++) {
            System.out.print(main.cc[i] + 1 + " ");
        }


    }

    public void dfs(int v) {
        used[v] = true;
        cc[v] = count;
        for (int i : adjanceList[v]) {
            if (!used[i]) {
                dfs(i);

            }
        }

    }
}
