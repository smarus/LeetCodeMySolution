package algorithms_coursera.graph;

import java.io.IOException;
import java.util.*;

public class Main {
    boolean[] used;
    List<List<Integer>> adjanceList = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> ((a.get(0) + a.get(1)) - (b.get(0) - b.get(1))));

        int n = sc.nextInt();
        int m = sc.nextInt();
        Main main = new Main();
        main.used = new boolean[n];
        for (int i = 0; i < n; i++) {
            main.adjanceList.add(new ArrayList<>());
        }

        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            main.adjanceList.get(u - 1).add(v - 1);
            main.adjanceList.get(v - 1).add(u - 1);
        }
        int startedPoint = sc.nextInt();
        System.out.println(main.adjanceList);
        main.dfs(startedPoint - 1);
        System.out.println(main.paths.size());
        for (int i = 0; i < main.paths.size(); i++) {
            System.out.println(main.paths.get(i) + " ");
        }

    }

    public void dfs(int v) {
        used[v] = true;
        paths.add(v + 1);

        for (int i : adjanceList.get(v)) {
            if (!used[i]) {
                dfs(i);
                paths.add(v + 1);
            }
        }

    }

}
