package educative.subset;

import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args) {
        //  System.out.println(generateParenthesis(3));
        List<String> strings = new ArrayList<>();
        generateParentRecursive(3, new char[3 * 2], 0, 0, 0, strings);
        System.out.println(strings);
    }


    public static List<String> generateParenthesis(int num) {

        List<String> generatedParathesis = new ArrayList<>();

        Deque<ParenthesisString> queue = new ArrayDeque<>();
        queue.add(new ParenthesisString("", 0, 0));

        while (!queue.isEmpty()) {
            ParenthesisString ps = queue.poll();
            System.out.println(ps.string);
            if (ps.openCount == num && ps.closeCount == num) {
                generatedParathesis.add(ps.string);
            } else {

                if (ps.openCount < num) {
                    queue.add(new ParenthesisString(ps.string + "(", ps.openCount + 1, ps.closeCount));
                }

                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesisString(ps.string + ")", ps.openCount, ps.closeCount + 1));
                }
            }

        }
        return generatedParathesis;
    }


    public static void generateParentRecursive(int num, char[] buffer, int openCount, int closeCount, int index, List<String> total) {

        if (openCount == num && closeCount == num)
            total.add(new String(buffer));
        else {
            if (openCount < num) {
                buffer[index] = '(';
                generateParentRecursive(num, buffer, openCount + 1, closeCount, index + 1, total);
            }

            if (closeCount < openCount) {
                buffer[index] = ')';
                generateParentRecursive(num, buffer, openCount, closeCount + 1, index + 1, total);
            }

        }
    }

    static class ParenthesisString {
        int openCount;
        int closeCount;
        String string;

        public ParenthesisString(String string, int openCount, int closeCount) {
            this.string = string;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

}
