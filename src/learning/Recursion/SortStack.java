package learning.Recursion;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(0);
        stack.push(1);
        stack.push(5);

        System.out.println(stack);
        sortStack(stack);

        System.out.println(stack);
        System.out.println(stack.peek());

    }


    public static void sortStack(Stack<Integer> stack) {
        if (stack.size() == 1)
            return;

        int temp = stack.pop();
        sortStack(stack);
        insert(stack, temp);

    }

    public static void insert(Stack<Integer> stack, Integer element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        Integer value = stack.pop();
        insert(stack, element);
        stack.push(value);
    }


}
