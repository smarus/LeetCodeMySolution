package leetcode.easy.string.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet1436 {
    public static void main(String[] args) {
        List<List<String>> graph = Arrays.asList(
                Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo")
        );

        System.out.println(destCity(graph));
    }

    static String destCity(List<List<String>> paths) {

        Set<String> path = new HashSet<>();

        for (List<String> p : paths) {
            path.add(p.get(0));
        }

        for (List<String> p : paths) {
            if (path.add(p.get(1))) {
                return p.get(1);
            }
        }

        return null;

    }
}
