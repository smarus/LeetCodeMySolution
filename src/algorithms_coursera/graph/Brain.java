package algorithms_coursera.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Brain {
    int[] used;
    boolean is_cycle_found = false;
    int cycle_start;
    ArrayList<Integer>[] adjanceList;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Brain main = new Brain();
        main.used = new int[n];
        main.cycle_start = -1;
        main.adjanceList = new ArrayList[n];
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
            if (main.used[i] == 0 && main.dfs(i))
                break;
        }

        if (main.cycle_start == -1)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    public boolean dfs(int v) {
        used[v] = 1;
        for (int i : adjanceList[v]) {

            if (used[i] == 0)
                if (dfs(i)) return true;

                else if (used[i] == 1) {
                    cycle_start = i;
                    return true;
                }
        }
        used[v] = 2;
        return false;
    }
}
