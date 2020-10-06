package easy.stack;


public class Leet1021 {
    public static void main(String[] args) {

    }

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int sum = 0;
        for (char c : chars) {
            if (c == '(') {
                if (sum > 0)
                    sb.append(c);
                sum += 1;
            } else {
                sum -= 1;
                if (sum > 0) sb.append(c);
            }
        }
        return sb.toString();

    }
}
