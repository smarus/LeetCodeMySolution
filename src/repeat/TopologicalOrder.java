package repeat;


import java.util.*;

public class TopologicalOrder {
    public static void main(String[] args) {
        List<Integer> result = TopologicalOrder.sort(4,
                new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}});
        System.out.println(result);

        result = TopologicalOrder.sort(5,
                new int[][]{{4, 2}, {4, 3}, {2, 1}, {3, 1}});
        System.out.println(result);
        result = TopologicalOrder.sort(7,
                new int[][]{{6, 4}, {6, 2}, {5, 4}, {5, 3}, {3, 0}, {3, 1}, {3, 2}, {4, 1}});
        System.out.println(result);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[][] edges = new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
        }

        List<Integer> sortedOrder = new ArrayList<>();
        int[] visited = new int[4];
        for (int i = 0; i < 4; i++) {
            if (visited[i] == 0)
                dfs(graph, visited, i, sortedOrder);
        }

        System.out.println(sortedOrder);
    }

    public static List<Integer> sort(int vertices, int[][] edges) {

        if (edges == null || edges.length == 0)
            return new ArrayList<>();

        List<Integer> sortedOrder = new ArrayList<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }


        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> pair : inDegree.entrySet()) {
            if (pair.getValue() == 0) {
                queue.offer(pair.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            sortedOrder.add(node);

            for (Integer child : graph.get(node)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        return sortedOrder;
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int[] visited, int vertex, List<Integer> sortedOrder) {
        visited[vertex] = 1;
        for (Integer children : graph.get(vertex)) {
            if (visited[children] == 0) {
                dfs(graph, visited, children, sortedOrder);
            } else if (visited[children] == 1) {
                System.out.println("Cycle Found");
                return;
            }
        }
        sortedOrder.add(0, vertex);
        visited[vertex] = 2;


    }
}
