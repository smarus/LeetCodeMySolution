package learning.Recursion;

import java.util.Stack;

public class DeleteMiddleOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //    deleteMiddleOfStack(stack);

        midDel(stack);
        System.out.println(stack);
    }

    public static void deleteMiddleOfStack(Stack<Integer> stack) {
        int middle = stack.size() / 2;
        deleteMiddle(stack, middle);
    }

    public static void deleteMiddle(Stack<Integer> stack, int middle) {
        if (stack.isEmpty())
            return;

        int value = stack.pop();
        deleteMiddle(stack, middle - 1);
        if (middle != 0)
            stack.push(value);
    }

    public static void midDel(Stack<Integer> st) {
        // Base Condition
        if (st.size() == 0) return;

        // Hypothesis
        int k = st.size() / 2 + 1; // calculating mid
        solve(st, k); // func. call
    }

    public static Stack<Integer> solve(Stack<Integer> st, int k) {
        // Base Condition
        if (st.size() == 1) {
            st.pop();
            return st;
        }

        // Hypothesis
        int temp = st.pop(); // removing 5 from stack
        solve(st, k - 1);

        // Induction
        st.push(temp);
        return st;
    }

}
