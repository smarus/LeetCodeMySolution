package educative.graph;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5,
                new int[][]{{4, 2}, {4, 3}, {2, 1}, {3, 1}});
        System.out.println(result);
        result = TopologicalSort.sort(7,
                new int[][]{{6, 4}, {6, 2}, {5, 4}, {5, 3}, {3, 0}, {3, 1}, {3, 2}, {4, 1}});
        System.out.println(result);
    }

    public static List<Integer> sort(int vertices, int[][] edges) {

        List<Integer> sortOrder = new ArrayList<>();
        if (vertices == 0 || edges == null)
            return sortOrder;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        //build graph
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        //create graph from edge list
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        if (sortOrder.size() != vertices) {
            return new ArrayList<>();
        }
        return sortOrder;
    }
}
