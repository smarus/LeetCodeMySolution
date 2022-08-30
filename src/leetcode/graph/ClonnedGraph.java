package leetcode.graph;


import java.util.*;

public class ClonnedGraph {

    Map<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {

    }

//    public Node cloneGraph(Node node) {
//        if (node == null)
//            return node;
//
//
//        if (visited.containsKey(node))
//            return visited.get(node);
//
//        Node clonnedNode = new Node(node.val, new ArrayList<>());
//        visited.put(node, clonnedNode);
//
//        for (Node neighbor: node.neighbour){
//            clonnedNode.neighbour.add(cloneGraph(neighbor));
//        }
//
//        return clonnedNode;
//
//    }

    public Node cloneGraph(Node node) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for (Node neighbor : n.neighbours) {
                if (!visited.containsKey(neighbor)) {
                    Node ne = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor, ne);
                    queue.offer(neighbor);
                }
                visited.get(n).neighbours.add(visited.get(neighbor));
            }

        }
        return visited.get(node);
    }

}
