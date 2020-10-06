package easy.stack;

import java.util.Iterator;
import java.util.Stack;

public class Leet1047 {
    public static void main(String[] args) {
        String string = "abbaca";
        System.out.println(removeDuplicates(string));
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
                continue;
            }

            if (stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Iterator<Character> iterator = stack.iterator(); iterator.hasNext(); ) {
            sb.append(iterator.next());
        }

        return sb.toString();
    }
}
