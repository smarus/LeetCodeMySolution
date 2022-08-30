package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(5, 3);
        graph.bfs(2);
    }

    static class Graph {
        boolean[] marked;
        ArrayList<Integer>[] adjancyList;

        public Graph(int vertex) {
            marked = new boolean[vertex];
            adjancyList = new ArrayList[vertex];
            for (int i = 0; i < vertex; i++) {
                adjancyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w) {
            adjancyList[v].add(w);
            adjancyList[w].add(v);
        }

        public void bfs(int source) {
            marked[source] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            System.out.print(source);
            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (int i : adjancyList[v]) {
                    if (!marked[i]) {
                        queue.offer(i);
                        System.out.print("----" + i);
                        marked[i] = true;
                    }
                }
            }
        }
    }

}
