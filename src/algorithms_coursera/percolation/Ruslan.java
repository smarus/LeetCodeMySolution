package algorithms_coursera.percolation;

import java.util.*;

class Ruslan {
    private static Integer calculateOp(Stack<Character> ops, Stack<Integer> vals) {
        int v = vals.pop();
        Character op = ops.pop();
        if (op == '+') {
            v = vals.pop() + v;
        } else if (op == '-') {
            v = vals.pop() - v;
        } else if (op == '*') {
            v = vals.pop() * v;
        } else if (op == '/') {
            v = vals.pop() / v;
        }
        return v;
    }

    public int solve(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> vals = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(') {
            } else if (character == '+') {
                ops.push(character);
            } else if (character == '-') {
                ops.push(character);
            } else if (character == '*') {
                ops.push(character);
            } else if (character == '/') {
                ops.push(character);
            } else if (character == ')') {
                vals.push(calculateOp(ops, vals));
            } else {
                vals.push(Integer.parseInt(String.valueOf(character)));
            }
        }
        return (calculateOp(ops, vals));
    }
}