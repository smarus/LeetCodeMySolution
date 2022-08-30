package leetcode.easy.arrays;

import java.util.Stack;

class Leet123 {

    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                Character c = stack.pop();
                if (Math.abs(c - s.charAt(i)) > 2) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}
