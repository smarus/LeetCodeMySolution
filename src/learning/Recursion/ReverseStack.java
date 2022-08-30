package learning.Recursion;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    public static void reverseStack(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;
        String order = "cba";

        int[] alfabet = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alfabet[order.charAt(i) - 'a'] = i + 1;
        }


        char[] orders = order.toCharArray();
        int val = stack.pop();


    }
}
