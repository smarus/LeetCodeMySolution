package repeat;

import java.util.ArrayList;
import java.util.List;

public class TopRecursive {

    public static void main(String[] args) {

        int[][] tasks = new int[][]{{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}};
        int number = 6;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] task : tasks) {
            int parent = task[0];
            int child = task[1];
            graph.get(parent).add(child);
        }


    }

}
