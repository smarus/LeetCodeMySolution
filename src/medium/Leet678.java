package medium;

import java.util.Stack;

public class Leet678 {
    public static void main(String[] args) {
        String string = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString(string));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        Stack<Character> star = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right.push('(');
            } else if (s.charAt(i) == ')') {
                left.push(')');
            } else {
                star.push('*');
            }
        }

        if (left.size() == right.size()) {
            return true;
        }
        while (!left.isEmpty() && !right.isEmpty()) {
            left.pop();
            right.pop();
        }

        if (!left.isEmpty() && star.size() >= left.size()) {
            return true;
        } else if (!right.isEmpty() && star.size() >= right.size()) {
            return true;
        }

        return true;
    }
}

//    public static boolean checkValidString(String s){
//        int closingBrackets = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '('){
//                closingBrackets++;
//            }else if (s.charAt(i) == ')'){
//                closingBrackets--;
//            }else{
//                if (closingBrackets > 0){
//                    closingBrackets--;
//                }else if (closingBrackets < 0)
//                    closingBrackets++;
//                else {
//
//                }
//            }
//        }
//        return  closingBrackets == 0;
//    }
//}
