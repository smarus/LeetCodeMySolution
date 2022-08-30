package repeat.contest.route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultiModule {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        while (TC-- > 0) {
            Map<String, List<String>> multiModule = new HashMap<>();
            Map<String, Integer> inDegree = new HashMap<>();
            int count = Integer.parseInt(reader.readLine());
            String line;
            while (true) {
                line = reader.readLine();
                if (line.isEmpty())
                    break;
                if (Character.isDigit(line.charAt(0)))
                    break;
                String[] nodes = line.split(" ");
                if (nodes.length == 1) {
                    String node = nodes[0].substring(0, nodes[0].length() - 1);
                    if (!multiModule.containsKey(node)) {
                        multiModule.put(node, new ArrayList<>());
                        inDegree.put(node, 0);
                    }

                } else {
                    String node = nodes[0].substring(0, nodes[0].length() - 1);
                    if (!multiModule.containsKey(node)) {
                        multiModule.put(node, new ArrayList<>());
                        inDegree.put(node, 0);
                    }
                    for (int i = 1; i < nodes.length; i++) {
                        if (!multiModule.containsKey(nodes[i])) {
                            inDegree.put(nodes[i], 0);
                            multiModule.put(nodes[i], new ArrayList<>());
                        }
                        multiModule.get(nodes[i]).add(node);
                        inDegree.put(node, inDegree.get(node) + 1);
                    }
                }
            }
            Queue<String> queue = new LinkedList<>();
            for (Map.Entry<String, Integer> source : inDegree.entrySet()) {
                if (source.getValue() == 0) {
                    queue.add(source.getKey());
                }
            }
            List<String> topOrder = new ArrayList<>();
            while (!queue.isEmpty()) {
                String module = queue.poll();
                topOrder.add(module);
                List<String> children = multiModule.get(module);
                for (String child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }
            int request = Integer.parseInt(line);
            Map<String, Boolean> visited = new HashMap<>();
            for (String string : topOrder) {
                visited.put(string, false);
            }

            while (request-- > 0) {
                String module = reader.readLine();
                dfs(multiModule, new HashSet<>(), module);

            }

        }
    }


    public static void dfs(Map<String, List<String>> multiModule, Set<String> visited, String module) {
        System.out.println(module);
        visited.add(module);
        for (String children : multiModule.get(module)) {
            if (!visited.contains(children)) {
                dfs(multiModule, visited, children);
            }
        }
    }


}
