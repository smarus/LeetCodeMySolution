package leetcode.easy.string.easy;

public class Leet1323 {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9999));
    }

    public static int maximum69Number(int num) {
        String nums = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        boolean change = true;
        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) == '6' && change) {
                sb.append('9');
                change = false;
                continue;
            }
            sb.append(nums.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
