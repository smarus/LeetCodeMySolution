package leetcode.medium;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//Input: s = "lee(t(c)o)de)"
//        Output: "lee(t(c)o)de"
//        Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
public class Leet1249 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public static String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;

        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> indexes = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                if (stack.isEmpty())
                    indexes.add(i);
                else
                    stack.pop();
            }
        }

        while (!stack.isEmpty()) indexes.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (indexes.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
