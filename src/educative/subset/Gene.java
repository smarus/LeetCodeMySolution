package educative.subset;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Gene {

    public static void main(String[] args) {
        System.out.println(generateParentesis(3));
        System.out.println(generateParentesis(2));
        System.out.println(generateParentesis(1));
        System.out.println();
        System.out.println(generateParentesisIterative(3));
        System.out.println(generateParentesisIterative(4));
        System.out.println(generateParentesisIterative(1));
    }


    public static List<String> generateParentesis(int n) {
        char[] buffer = new char[n * 2];
        List<String> total = new ArrayList<>();
        recursive(buffer, 0, 0, 0, n, total);
        return total;
    }

    public static List<String> generateParentesisIterative(int n) {
        List<String> total = new ArrayList<>();
        Deque<ParathesisString> paranthesis = new ArrayDeque<>();
        paranthesis.offer(new ParathesisString(0, 0, ""));

        while (!paranthesis.isEmpty()) {
            ParathesisString ps = paranthesis.poll();

            if (ps.close == n && ps.open == n) {
                total.add(ps.string);
            }
            if (ps.open < n) {
                paranthesis.offer(new ParathesisString(ps.close, ps.open + 1, ps.string + "("));
            }
            if (ps.close < ps.open) {
                paranthesis.offer(new ParathesisString(ps.close + 1, ps.open, ps.string + ")"));
            }

        }
        return total;
    }

    public static void recursive(char[] buffer, int bufferIndex, int close, int open, int num, List<String> total) {

        if (close == num && open == num) {
            total.add(new String(buffer));
            return;
        }

        if (open < num) {
            buffer[bufferIndex] = '(';
            recursive(buffer, bufferIndex + 1, close, open + 1, num, total);
        }

        if (close < open) {
            buffer[bufferIndex] = ')';
            recursive(buffer, bufferIndex + 1, close + 1, open, num, total);
        }

    }

    static class ParathesisString {
        int close;
        int open;
        String string;

        public ParathesisString(int close, int open, String string) {
            this.open = open;
            this.close = close;
            this.string = string;
        }
    }


}
